package com.kotlin.museamproject.di

import com.kotlin.museamproject.di.item.ObjectSubcomponent
import com.kotlin.museamproject.di.module.*
import com.kotlin.museamproject.mvp.presenter.MainPresenter
import com.kotlin.museamproject.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DatabaseModule::class,
        CiceroneModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun userSubcomponent() : ObjectSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}