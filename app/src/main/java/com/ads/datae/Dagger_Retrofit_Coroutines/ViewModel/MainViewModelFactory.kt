package com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ads.datae.Dagger_Retrofit_Coroutines.reposotory.ProductRespository
import com.ads.datae.Dragger.FirebaseRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}