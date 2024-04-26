package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ads.datae.MyApplicaton
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.ViewModel.MainViewModel
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.ViewModel.MainViewModelFactory
import com.ads.lifecycleawarecomponents.R

class RetrofitCoroutineActivty : AppCompatActivity() {
  lateinit var  mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_coroutine_activty)

        val quotesRepository = (application as MyApplicaton).quotesRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(quotesRepository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {

            when(it)
            {
                is Response.Loading -> {}
                is Response.Sucess -> {
                    Log.e("MVVM_DATA : ", it.data?.results?.size.toString())
                }
                is Response.Error -> {
                    Log.e("MVVM_DATA : ", it.error.toString())

                }
            }

//            it.results.forEach {
//                Log.e("MVVM_DATA : ",it.content.toString())
//
//            }
        })
    }
}