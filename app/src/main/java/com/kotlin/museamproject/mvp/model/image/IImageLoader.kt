package com.kotlin.museamproject.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}