package com.kotlin.museamproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.museamproject.R
import com.kotlin.museamproject.di.repository.RepositorySubcomponent
import com.kotlin.museamproject.mvp.model.entity.PictureObject
import com.kotlin.museamproject.mvp.model.image.IImageLoader
import com.kotlin.museamproject.mvp.presenter.ObjectPresenter
import com.kotlin.museamproject.mvp.view.ObjectView
import com.kotlin.museamproject.ui.App
import com.kotlin.museamproject.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_object.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ObjectFragment : MvpAppCompatFragment(), ObjectView, BackButtonListener {

    companion object {
        private const val REPOSITORY_ARG = "repository"

        fun newInstance(repository: PictureObject) = ObjectFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }


    val presenter: ObjectPresenter by moxyPresenter {
        val repositorySubcomponent = App.instance.initRepositorySubcomponent()
        val repository = arguments?.getParcelable<PictureObject>(REPOSITORY_ARG) as PictureObject
        ObjectPresenter(repository).apply {
            repositorySubcomponent?.inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_object, null)

    override fun init() {

    }

    override fun setTitle(text: String) {
        title.text = text
    }

    override fun loadImage(url: String, imageLoader: IImageLoader<ImageView>) {
        imageLoader.loadInto(url, image)
    }

    override fun setAuthor(text: String) {
        author.text = text
    }


    override fun backPressed() = presenter.backPressed()

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("onDestroy")
    }
}