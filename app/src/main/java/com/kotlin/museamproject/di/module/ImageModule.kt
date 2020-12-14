package com.kotlin.museamproject.di.module

import android.widget.ImageView

import com.kotlin.museamproject.mvp.model.cashe.image.IImageCache
import com.kotlin.museamproject.mvp.model.cashe.image.room.RoomImageCache
import com.kotlin.museamproject.mvp.model.entity.room.Database
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.model.network.INetworkStatus
import com.kotlin.museamproject.ui.App
import com.kotlin.museamproject.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("cacheDir")
    @Singleton
    @Provides
    fun cacheDir(app: App): File = app.cacheDir

    @Singleton
    @Provides
    fun imageCache(database: Database, @Named("cacheDir") cacheDir: File): IImageCache = RoomImageCache(database, cacheDir)

    @Singleton
    @Provides
    fun imageLoader(cache: IImageCache, networkStatus: INetworkStatus): IImageLoader<ImageView> = GlideImageLoader(cache, networkStatus)

}