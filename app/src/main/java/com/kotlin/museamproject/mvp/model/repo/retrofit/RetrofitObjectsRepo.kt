package com.kotlin.museamproject.mvp.model.repo.retrofit

import com.kotlin.museamproject.mvp.model.api.IDataSource
import com.kotlin.museamproject.mvp.model.cashe.IObjectsCache
import com.kotlin.museamproject.mvp.model.network.INetworkStatus
import com.kotlin.museamproject.mvp.model.repo.IObjectsRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitObjectsRepo(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IObjectsCache) :
    IObjectsRepo {

    override fun getObject(id: Int) = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
                api.getObject(id).flatMap { users ->
                    cache.putObject(users).toSingleDefault(users)
                }
        } else {
            cache.getObject(id)
        }
    }.subscribeOn(Schedulers.io())
}