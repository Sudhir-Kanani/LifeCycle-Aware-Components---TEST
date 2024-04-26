package com.ads.datae.Dagger_Retrofit_Coroutines.Retrofit

import com.ads.datae.Dagger_Retrofit_Coroutines.Model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {
    @GET("products")
   suspend fun getProduct() : Response<List<Product>>
}