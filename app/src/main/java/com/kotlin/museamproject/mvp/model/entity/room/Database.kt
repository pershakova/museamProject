package com.kotlin.museamproject.mvp.model.entity.room

import androidx.room.RoomDatabase
import com.kotlin.museamproject.mvp.model.entity.room.dao.ImageDao
import com.kotlin.museamproject.mvp.model.entity.room.dao.PictureObjectDao

@androidx.room.Database(entities = [RoomPictureObject::class, RoomCachedImage::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val objectDao: PictureObjectDao
    abstract val imageDao: ImageDao

    companion object {
        const val DB_NAME = "database.db"
    }
}