package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit.Result


@Database(entities = [Result::class], version = 1)
abstract class  QuoteDB : RoomDatabase() {

    abstract fun  quoteDao() : QuoteDao

    companion object
    {

        private var INSTERNT:QuoteDB? = null

        fun getDatabse (context: Context):QuoteDB
        {
            if (INSTERNT ==null)
            {
                synchronized(this)
                {
                    INSTERNT = Room.databaseBuilder(context, QuoteDB::class.java, "quoteeeDB")
                        .build()
                }
            }
            return INSTERNT!!
        }


    }

}