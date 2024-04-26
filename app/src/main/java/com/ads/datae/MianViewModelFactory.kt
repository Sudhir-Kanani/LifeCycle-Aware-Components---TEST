package com.ads.datae

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MianViewModelFactory(val initValue:Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(initValue) as T
    }
}