package com.kotlin.museamproject.di.repository

import android.widget.ImageView
import com.kotlin.museamproject.di.module.ImageModule
import com.kotlin.museamproject.di.repository.module.RepositoryModule
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.presenter.ObjectPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class,

    ]
)
interface RepositorySubcomponent {
    fun inject(objectPresenter: ObjectPresenter)

    fun inject(imageLoader: IImageLoader<ImageView>)
}