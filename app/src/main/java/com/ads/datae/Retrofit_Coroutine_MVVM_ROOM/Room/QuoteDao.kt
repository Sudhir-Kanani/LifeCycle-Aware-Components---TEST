package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.Result


@Dao
interface QuoteDao {

    @Insert
    suspend fun addqueote(quote:List<Result>?)

    @Query("SELECT * FROM quotess")
    suspend fun getQuotes():List<Result>
}