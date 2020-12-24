package com.example.project_4a_kadioglu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModule: ViewModel()
{
    val counter: MutableLiveData<Int> = MutableLiveData()

    init
    {
        counter.value = 0
    }

    fun onClickedIncrement() {
        counter.value = (counter.value ?: 0) + 1
    }
}