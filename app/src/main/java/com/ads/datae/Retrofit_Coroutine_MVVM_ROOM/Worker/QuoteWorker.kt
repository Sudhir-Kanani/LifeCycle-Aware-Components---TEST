package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ads.datae.MyApplicaton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private val context: Context,workerParameters: WorkerParameters):Worker(context,workerParameters) {
    override fun doWork(): Result {
        val respositry  = (context as MyApplicaton).quotesRepository
        CoroutineScope(Dispatchers.IO).launch {
            respositry.getQuoteBackground()

        }
        return Result.success()

    }
}