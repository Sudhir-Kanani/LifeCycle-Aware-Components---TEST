package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuetos(@Query("page") page:Int) : Response<QuoteList>
}