package com.ads.datae.Dagger_Retrofit_Coroutines.DI

import com.ads.datae.Dagger_Retrofit_Coroutines.Retrofit.FakerApi
import com.ads.datae.Dagger_Retrofit_Coroutines.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModul {

    @Singleton
    @Provides
    fun provideRestrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFakerApi(retrofit: Retrofit): FakerApi {
        return retrofit.create(FakerApi::class.java)
    }
}