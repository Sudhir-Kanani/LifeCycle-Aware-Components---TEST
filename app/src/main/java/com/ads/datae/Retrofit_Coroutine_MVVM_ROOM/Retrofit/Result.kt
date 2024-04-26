package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotess")
data class Result(

    @PrimaryKey(autoGenerate = true)
    val quoteId:Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)