package com.ads.datae.Dagger_Retrofit_Coroutines

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ads.datae.Dagger_Retrofit_Coroutines.DB.FakerDB
import com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel.MainViewModel
import com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel.MainViewModelFactory
import com.ads.datae.MyApplicaton
import com.ads.lifecycleawarecomponents.R
import javax.inject.Inject

class Dagger_Retrofit_Coroutines_Activity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

        @Inject
        lateinit var mainViewModelFactory: MainViewModelFactory


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dagger_retrofit_coroutines)

            (application as MyApplicaton).applicationComponent.inject(this)

            mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

            val product = findViewById<TextView>(R.id.product)

        mainViewModel.productLiveData.observe(this) {
            product.text = it.joinToString { it.title + "\n\n" }
        }
    }
}