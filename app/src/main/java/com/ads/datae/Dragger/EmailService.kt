package com.ads.datae.Dragger

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService {
    fun send(to:String,from:String, body:String)
}
@Singleton
class EmailService @Inject constructor() : NotificationService {
    override fun send(to:String, from:String, body:String)
    {
        Log.e("SAVEUSER","Mail send")
    }
}
class MessageService(val retryCount:Int) :NotificationService{
    override fun send(to: String, from: String, body: String) {
        Log.e("SAVEUSER","Message send : $retryCount")
    }

}
