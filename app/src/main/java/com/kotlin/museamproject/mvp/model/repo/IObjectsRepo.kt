package com.kotlin.museamproject.mvp.model.repo

import com.kotlin.museamproject.mvp.model.entity.PictureObject
import io.reactivex.rxjava3.core.Single

interface IObjectsRepo {
    fun getObject(id : Int): Single<PictureObject>
}