package com.example.blandmyscreen.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {

    private val ind = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(ind) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        ind.value = index
    }
}