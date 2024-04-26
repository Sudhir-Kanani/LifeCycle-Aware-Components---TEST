package com.ads.datae.Dragger

import android.util.Log

interface AnalysticsService {
    fun trackEvent(eventName: String, eventype: String)
}

class Mixpanal : AnalysticsService {
    override fun trackEvent(eventName: String, eventype: String) {
        Log.d("AnalysticsService : ", "Mixpanal - $eventName - $eventype")
    }

}

class FirebaseAnalystics : AnalysticsService {
    override fun trackEvent(eventName: String, eventype: String) {
        Log.d("AnalysticsService : ", "Firebase - $eventName - $eventype")
    }

}