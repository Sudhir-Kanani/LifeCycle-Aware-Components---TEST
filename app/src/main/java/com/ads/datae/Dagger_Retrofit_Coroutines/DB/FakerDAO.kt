package com.ads.datae.Dagger_Retrofit_Coroutines.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ads.datae.Dagger_Retrofit_Coroutines.Model.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProduct(): List<Product>
}