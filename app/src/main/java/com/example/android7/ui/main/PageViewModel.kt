package com.example.android7.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = _index.map {
        "Hello world from section: $it"
    }

    val list: LiveData<List<Item>> = _index.map {
        if(it == 0) {
            listOf(
                Item("header", "Гостинная", ""),
                Item("item", "Камера 1", ""),
                Item("item", "Камера 2", ""),
                Item("header", "Спальня", ""),
                Item("item", "Камера 3", ""),
                Item("item", "Камера 4", ""),
                Item("item", "Камера 5", ""),
            )
        } else {
            listOf()
        }
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}