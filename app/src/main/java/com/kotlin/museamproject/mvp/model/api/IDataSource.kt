package com.kotlin.museamproject.mvp.model.api

import com.kotlin.museamproject.mvp.model.entity.PictureObject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IDataSource {
    @GET("/objects")
    fun getObjects(): Single<PictureObject>

    @GET("objects/{user_id}")
    fun getObject(@Path(value = "user_id", encoded = true)  userId : Int): Single<PictureObject>
}