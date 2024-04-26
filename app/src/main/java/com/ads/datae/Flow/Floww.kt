package com.ads.datae.Flow

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        val data = stateProduction()
        data.collect(){
            Log.e("CHEEZYCODE==> data => ", "$it")
        }
//        val data1 = stateProduction()
//        data1.collect(){
//            Log.e("CHEEZYCODE==> data1 => ", "$it")
//        }
    }
}
fun stateProduction(): Flow<Int> {
    val mutableStateFlow = MutableStateFlow(10)

    GlobalScope.launch {
        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            mutableStateFlow.emit(it)
            delay(1000)
        }
    }
    return mutableStateFlow
}
