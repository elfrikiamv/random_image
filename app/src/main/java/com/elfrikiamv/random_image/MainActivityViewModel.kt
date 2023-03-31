package com.elfrikiamv.random_image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {

    private var urlImage: MutableLiveData<String?>? = null

    fun getUrlImage(): MutableLiveData<String?>? {

        if (urlImage == null) {
            urlImage = MutableLiveData<String?>()
            randomUrlImage()
        }

        return urlImage
    }

    fun randomUrlImage() {

        val random = (1..1000).random()
        urlImage?.value = "https://picsum.photos/id/$random/400/600"
    }
}