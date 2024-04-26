package com.ads.datae.Dragger

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository{
    fun saveUser(email:String,password:String)
}
@Singleton
class SQLRepository @Inject constructor(val analysticsService: AnalysticsService):UserRepository{
    override fun saveUser(email:String, password:String)
    {
        Log.e("SAVEUSER : ","SAVED in DB")
        analysticsService.trackEvent("Save User","Create")
    }
}
class FirebaseRepository(val analysticsService: AnalysticsService) : UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.e("SAVEUSER : ","SAVED in Firebase")
        analysticsService.trackEvent("Save User","Create")

    }

}