package com.ads.datae

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.ads.datae.Dagger_Retrofit_Coroutines.DI.ApplicationComponent
import com.ads.datae.Dagger_Retrofit_Coroutines.DI.DaggerApplicationComponent
import com.ads.datae.Dragger.DaggerUserRegistrationComponet
import com.ads.datae.Dragger.UserRegistrationComponet
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.QuoteApi
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.RetrofitHelper
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Room.QuoteDB
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.ViewModel.QuotesRepository
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Worker.QuoteWorker
import java.util.concurrent.TimeUnit

class MyApplicaton : Application() {
    lateinit var quotesRepository:QuotesRepository
    lateinit var userRegistrationComponet: UserRegistrationComponet

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        init()
        initWorker()

        userRegistrationComponet =  DaggerUserRegistrationComponet.factory().creare(3)

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    private fun initWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerequest  = PeriodicWorkRequest.Builder(QuoteWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()

        WorkManager.getInstance(this).enqueue(workerequest)
    }

    private fun init() {

        val quotesApi = RetrofitHelper.getInstance(this).create(QuoteApi::class.java)
        val quoteDB = QuoteDB.getDatabse(applicationContext)

        quotesRepository = QuotesRepository(quotesApi,quoteDB,applicationContext)
    }

}