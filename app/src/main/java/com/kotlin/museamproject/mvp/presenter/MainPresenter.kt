package com.kotlin.museamproject.mvp.presenter

import com.kotlin.museamproject.mvp.view.MainView
import com.kotlin.museamproject.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.ObjectsScreen())
    }

    fun backClicked() {
        router.exit()
    }
}
