package com.ads.datae

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LivedataViewmodel :ViewModel(){

    val livedataViewmodel  = MutableLiveData<String>("This is test")

    fun UpdateText()
    {
        livedataViewmodel.value = "Test Complite"
    }

}