package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit

import android.content.Context
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

object RetrofitHelper {
    val BASEURL = "https://api.quotable.io/"

    fun getInstance(context: Context):Retrofit
    {
        val cacheSize = (5 * 1024 * 1024).toLong() // 5 MB
        val cache = Cache(context.cacheDir, cacheSize)
        val clint = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.MINUTES)
            .cache(cache).build()

        val cacheControl = CacheControl.Builder()
            .maxStale(1,TimeUnit.MINUTES)
            .build()

        val request = Request.Builder()
            .url(BASEURL)
            .cacheControl(cacheControl)
            .build()


        return Retrofit.Builder().baseUrl(BASEURL).client(clint).addConverterFactory(GsonConverterFactory.create()).build()
    }
}