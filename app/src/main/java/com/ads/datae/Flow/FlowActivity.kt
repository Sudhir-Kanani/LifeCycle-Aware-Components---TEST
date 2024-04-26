package com.ads.datae.Flow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ads.lifecycleawarecomponents.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)



        GlobalScope.launch {


            val data = productor()
            data
                .onStart {
                    Log.e("CHEEZYCODE==> ", "Start")

                }
                .onCompletion {
                    Log.e("CHEEZYCODE==> ", "onCompletion")

                }
                .onEach {
                    Log.e("CHEEZYCODE==> ", "onEach : $it ")

                }
                .map { }
                .flowOn(Dispatchers.IO)
                .collect() {
                    Log.e("CHEEZYCODE==> ", "$it")
                }
        }

    }
//    fun latestNews(): Flow<Any> = flow<Any> {
//    }.shareIn(
//        replay = 1,
//        started = SharingStarted.WhileSubscribed()
//    )

    fun productor() = flow<Int>
    {


        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }.catch {

    }

    fun sharedProduction(): Flow<Int> {
        val mutableSharedFlow = MutableSharedFlow<Int>(1)

        GlobalScope.launch {
            val list = listOf(1, 2, 3, 4, 5)
            list.forEach {
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
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
}