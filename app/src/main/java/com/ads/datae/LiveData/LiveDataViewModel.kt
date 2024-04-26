package com.ads.datae.LiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel :ViewModel(){
    val liveData = MutableLiveData<String>("Defult")
    fun updateData()
    {
        liveData.value = "New Values Set"
    }
}