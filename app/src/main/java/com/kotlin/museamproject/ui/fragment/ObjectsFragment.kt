package com.kotlin.museamproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.museamproject.R
import com.kotlin.museamproject.di.item.ObjectSubcomponent
import com.kotlin.museamproject.mvp.presenter.ObjectsPresenter
import com.kotlin.museamproject.mvp.view.ObjectsView
import com.kotlin.museamproject.ui.App
import com.kotlin.museamproject.ui.BackButtonListener
import com.kotlin.museamproject.ui.adapter.ObjectsRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_objects.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ObjectsFragment : MvpAppCompatFragment(), ObjectsView, BackButtonListener {

    companion object {
        fun newInstance() = ObjectsFragment()
    }

    var userSubcomponent: ObjectSubcomponent? = null

    val presenter: ObjectsPresenter by moxyPresenter {
        userSubcomponent = App.instance.initUserSubcomponent()
        ObjectsPresenter(AndroidSchedulers.mainThread()).apply {
            userSubcomponent?.inject(this)
        }
    }

    var adapter: ObjectsRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_objects, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(context)
        adapter = ObjectsRVAdapter(presenter.usersListPresenter).apply {
            userSubcomponent?.inject(this)
        }
        rv_users.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    override fun release() {
        userSubcomponent = null
        App.instance.releaseUserSubcomponent()
    }
}