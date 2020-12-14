package com.kotlin.museamproject.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ObjectsView : MvpView {
    fun init()
    fun updateList()
    fun release()
}