package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Response
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuotesRepository) : ViewModel() {

    init {
          viewModelScope.launch(Dispatchers.IO) {
              repository.getQuotes(1)
          }
    }

    val quotes : LiveData<Response<QuoteList>>
        get() = repository.quotes

}