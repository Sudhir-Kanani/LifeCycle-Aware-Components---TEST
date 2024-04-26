package com.ads.datae.Dagger_Retrofit_Coroutines.reposotory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.RoomDatabase
import com.ads.datae.Dagger_Retrofit_Coroutines.DB.FakerDB
import com.ads.datae.Dagger_Retrofit_Coroutines.Model.Product
import com.ads.datae.Dagger_Retrofit_Coroutines.Retrofit.FakerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class ProductRespository @Inject constructor(
    private val fakerApi: FakerApi,
    private val fakerDB: FakerDB
) {

    private val _projuct = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>>
        get() = _projuct

    suspend fun getProjuct() {
        val result = fakerApi.getProduct()

        if (result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDao().addProduct(result.body()!!)
            _projuct.postValue(result.body())
        }
    }
}
