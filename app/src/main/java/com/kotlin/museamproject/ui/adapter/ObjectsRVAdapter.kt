package com.kotlin.museamproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.museamproject.R
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.presenter.list.IObjectListPresenter
import com.kotlin.museamproject.mvp.view.list.ObjectItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_object.view.*
import javax.inject.Inject

class ObjectsRVAdapter(val presenter: IObjectListPresenter) : RecyclerView.Adapter<ObjectsRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_object, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.removeAvatar()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer, ObjectItemView {
        override var pos = -1
        override fun setLogin(text: String) = with(containerView) { tv_login.text = text }
        override fun loadAvatar(url: String) = with(containerView) { imageLoader.loadInto(url, iv_avatar) }
        fun removeAvatar() = with(containerView) { iv_avatar.setImageDrawable(null) }
    }
}