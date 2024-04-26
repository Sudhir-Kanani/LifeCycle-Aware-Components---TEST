package com.ads.datae

import androidx.lifecycle.ViewModel

class MainViewModel(val initvalue:Int) : ViewModel() {
    var count:Int = initvalue;

    fun increment()
    {
        count++
    }
}