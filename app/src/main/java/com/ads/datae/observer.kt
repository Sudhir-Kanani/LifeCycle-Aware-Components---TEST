package com.ads.datae

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class observer :LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onCreate()
    {
        Log.d("CALLMETHOD  : ","Observer == > onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumn()
    {
        Log.d("CALLMETHOD  : ","Observer == > onResumn")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause()
    {
        Log.d("CALLMETHOD  : ","Observer == > onPause")
    }
}