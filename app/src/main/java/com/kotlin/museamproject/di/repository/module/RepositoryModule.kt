package com.kotlin.museamproject.di.repository.module

import com.kotlin.museamproject.di.repository.RepositoryScope
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
open class RepositoryModule {

    @Provides
    fun repositoriesCache(database: Database): IObjectsCache {
        return RoomObjectsCache(database)
    }

    @RepositoryScope
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo {
        return RetrofitObjectsRepo(api, networkStatus, cache)
    }
}