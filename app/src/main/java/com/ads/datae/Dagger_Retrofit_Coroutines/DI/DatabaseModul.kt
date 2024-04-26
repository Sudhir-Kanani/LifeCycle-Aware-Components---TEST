package com.ads.datae.Dagger_Retrofit_Coroutines.DI

import android.content.Context
import androidx.room.Room
import com.ads.datae.Dagger_Retrofit_Coroutines.DB.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModul {

    @Singleton
    @Provides
    fun provideFakerDb(context : Context):FakerDB{
        return  Room.databaseBuilder(context,FakerDB::class.java,"FakerDB").build()
    }
}