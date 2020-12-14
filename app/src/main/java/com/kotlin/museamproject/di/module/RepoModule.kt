package com.kotlin.museamproject.di.module

import com.kotlin.museamproject.mvp.model.api.IDataSource
import com.kotlin.museamproject.mvp.model.cashe.IObjectsCache
import com.kotlin.museamproject.mvp.model.network.INetworkStatus
import com.kotlin.museamproject.mvp.model.repo.IObjectsRepo
import com.kotlin.museamproject.mvp.model.repo.retrofit.RetrofitObjectsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun objectRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo =
        RetrofitObjectsRepo(api, networkStatus, cache)

}