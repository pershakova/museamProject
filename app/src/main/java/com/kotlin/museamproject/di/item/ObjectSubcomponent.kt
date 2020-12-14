package com.kotlin.museamproject.di.item

import android.widget.ImageView
import com.kotlin.museamproject.di.item.module.ObjectModule
import com.kotlin.museamproject.di.repository.RepositorySubcomponent
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.presenter.ObjectPresenter
import com.kotlin.museamproject.mvp.presenter.ObjectsPresenter
import com.kotlin.museamproject.ui.adapter.ObjectsRVAdapter
import dagger.Subcomponent

@ObjectScope
@Subcomponent(
    modules = [
        ObjectModule::class
    ]
)
interface ObjectSubcomponent {
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(usersPresenter: ObjectsPresenter)
    fun inject(usersRVAdapter: ObjectsRVAdapter)

    fun inject(objectPresenter: ObjectPresenter)
}