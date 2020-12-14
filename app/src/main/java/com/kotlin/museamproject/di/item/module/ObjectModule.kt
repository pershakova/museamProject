package com.kotlin.museamproject.di.item.module

import com.kotlin.museamproject.di.item.ObjectScope
import com.kotlin.museamproject.mvp.model.api.IDataSource
import com.kotlin.museamproject.mvp.model.cashe.IObjectsCache
import com.kotlin.museamproject.mvp.model.cashe.room.RoomObjectsCache
import com.kotlin.museamproject.mvp.model.entity.room.Database
import com.kotlin.museamproject.mvp.model.network.INetworkStatus
import com.kotlin.museamproject.mvp.model.repo.IObjectsRepo
import com.kotlin.museamproject.mvp.model.repo.retrofit.RetrofitObjectsRepo
import dagger.Module
import dagger.Provides

@Module
open class ObjectModule {

    @Provides
    fun usersCache(database: Database): IObjectsCache {
        return RoomObjectsCache(database)
    }


    @ObjectScope
    @Provides
    open fun usersRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo {
        return RetrofitObjectsRepo(api, networkStatus, cache)
    }
}