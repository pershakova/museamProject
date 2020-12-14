package com.kotlin.museamproject.mvp.presenter

import com.kotlin.museamproject.mvp.model.entity.PictureObject
import com.kotlin.museamproject.mvp.model.repo.IObjectsRepo
import com.kotlin.museamproject.mvp.presenter.list.IObjectListPresenter
import com.kotlin.museamproject.mvp.view.ObjectsView
import com.kotlin.museamproject.mvp.view.list.ObjectItemView
import com.kotlin.museamproject.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ObjectsPresenter(val mainThreadScheduler: Scheduler) : MvpPresenter<ObjectsView>() {

    @Inject
    lateinit var usersRepo: IObjectsRepo
    @Inject
    lateinit var router: Router

    class UsersListPresenter : IObjectListPresenter {
        val pictureObjects = mutableListOf<PictureObject>()
        override var itemClickListener: ((ObjectItemView) -> Unit)? = null
        override fun getCount() = pictureObjects.size

        override fun bindView(view: ObjectItemView) {
            val pictureObject = pictureObjects[view.pos]
            pictureObject.title?.let { view.setLogin(it) }
            pictureObject.primaryImageSmall?.let { view.loadAvatar(it) }
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.pictureObjects[itemView.pos]
            router.navigateTo(Screens.ObjectScreen(user))
        }
    }

    fun loadData() {
        usersListPresenter.pictureObjects.clear()
        val arr = intArrayOf(248798, 437056, 361509, 361300, 38153, 551786, 317877, 329077)
        for (item in arr){
            usersRepo.getObject(item)
                    .observeOn(mainThreadScheduler)
                    .subscribe({ items ->
                        usersListPresenter.pictureObjects.add(items)
                        viewState.updateList()
                    }, {
                        println("Error: ${it.message}")
                    })
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }
}