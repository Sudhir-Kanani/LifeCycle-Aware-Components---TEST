package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Response
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.QuoteApi
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.QuoteList
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Room.QuoteDB
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.utils.NetworkUtil
import retrofit2.Call
import retrofit2.Callback

class QuotesRepository(
    private val quoteApi: QuoteApi,
    private val quoteDB: QuoteDB,
    private val context: Context
) {

    private val quotesLiveData = MutableLiveData<Response<QuoteList>>()

    val quotes: LiveData<Response<QuoteList>>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int) {

        if (NetworkUtil.isInternetAvailable(context)) {
                try {
                    val result = quoteApi.getQuetos(page)
                if (result?.body() != null) {
                    quoteDB.quoteDao().addqueote(result.body()!!.results)
                    quotesLiveData.postValue(Response.Sucess(result.body()))
                } else {
                    quotesLiveData.postValue(Response.Error("ERROR !!"))
                    Log.e("MVVM_DATA : ", result.message().toString())
                    Log.e("MVVM_DATA : ", result.code().toString())
                }
            } catch (e: Exception) {
                quotesLiveData.postValue(Response.Error("ERROR"))
                Log.e("MVVM_DATA : ", e.toString())
                Log.e("MVVM_DATA : ", e.message.toString())
            }

        } else {
            val quotes = quoteDB.quoteDao().getQuotes()
            val quotesList = QuoteList(1, 1, 1, quotes, 1, 1)
            quotesLiveData.postValue(Response.Sucess(quotesList))
        }


    }

    suspend fun getQuoteBackground() {
        val randomNumber = (Math.random() * 10).toInt()
        val result = quoteApi.getQuetos(randomNumber)
        if (result?.body() != null) {
            quoteDB.quoteDao().addqueote(result.body()!!.results)
        }
    }
}

