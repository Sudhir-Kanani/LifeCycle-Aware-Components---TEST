package com.ads.datae.Dagger_Retrofit_Coroutines.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ads.datae.Dagger_Retrofit_Coroutines.Model.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {
    abstract fun getFakerDao(): FakerDAO
}