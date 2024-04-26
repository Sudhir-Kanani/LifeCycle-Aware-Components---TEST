package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM.Retrofit

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)