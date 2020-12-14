package com.kotlin.museamproject.mvp.model.cashe.room

import com.kotlin.museamproject.mvp.model.cashe.IObjectsCache
import com.kotlin.museamproject.mvp.model.entity.PictureObject
import com.kotlin.museamproject.mvp.model.entity.room.Database
import com.kotlin.museamproject.mvp.model.entity.room.RoomPictureObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomObjectsCache(val db: Database) : IObjectsCache {

   override fun putObject(pictureObject: PictureObject) = Completable.fromAction {
        val roomPictureObject =  RoomPictureObject(pictureObject.objectID,pictureObject.title ?: "", pictureObject.primaryImage?: "" , pictureObject.primaryImageSmall ?: "", pictureObject.artistDisplayName ?: "")
        db.objectDao.insert(roomPictureObject)
    }.subscribeOn(Schedulers.io())

    override fun getObject(id: Int): Single<PictureObject> = Single.fromCallable {
        val roomPictureObjectFromDb = db.objectDao.findById(id) ?: throw RuntimeException("No such user in cache")

        return@fromCallable PictureObject(roomPictureObjectFromDb.id, roomPictureObjectFromDb.primaryImage, roomPictureObjectFromDb.primaryImageSmall, roomPictureObjectFromDb.title, roomPictureObjectFromDb.artistDisplayName)
    }
}