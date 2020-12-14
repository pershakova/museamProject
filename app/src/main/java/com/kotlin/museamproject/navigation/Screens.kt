package com.kotlin.museamproject.navigation

import com.kotlin.museamproject.mvp.model.entity.PictureObject
import com.kotlin.museamproject.ui.fragment.ObjectFragment
import com.kotlin.museamproject.ui.fragment.ObjectsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class ObjectsScreen() : SupportAppScreen() {
        override fun getFragment() = ObjectsFragment.newInstance()
    }

    class ObjectScreen(val pictureObject: PictureObject) : SupportAppScreen() {
        override fun getFragment() = ObjectFragment.newInstance(pictureObject)
    }

}