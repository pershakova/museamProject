package com.kotlin.museamproject.mvp.presenter

import android.widget.ImageView
import com.kotlin.museamproject.mvp.model.entity.PictureObject
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.model.repo.IObjectsRepo
import com.kotlin.museamproject.mvp.view.ObjectView
import com.kotlin.museamproject.mvp.view.list.RepositoryItemView
import com.kotlin.museamproject.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ObjectPresenter(val pictureObject: PictureObject) : MvpPresenter<ObjectView>() {

    @Inject lateinit var router: Router

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setAuthor(pictureObject.artistDisplayName ?: "")
        viewState.setTitle(pictureObject.title ?: "")
        viewState.loadImage((pictureObject.primaryImage ?: 0).toString(), imageLoader)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("onDestroy presenter")
    }
}