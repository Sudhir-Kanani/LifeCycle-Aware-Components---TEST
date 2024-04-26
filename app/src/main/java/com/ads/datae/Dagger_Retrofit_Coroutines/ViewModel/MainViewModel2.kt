package com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ads.datae.Dagger_Retrofit_Coroutines.Model.Product
import com.ads.datae.Dagger_Retrofit_Coroutines.reposotory.ProductRespository
import com.bumptech.glide.Glide.init
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel2 @Inject constructor():ViewModel() {
    init {
        viewModelScope.launch {
        }
    }
}
