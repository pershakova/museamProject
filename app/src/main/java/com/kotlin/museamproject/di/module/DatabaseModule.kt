package com.kotlin.museamproject.di.module


import androidx.room.Room
import com.kotlin.museamproject.mvp.model.entity.room.Database
import com.kotlin.museamproject.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

}