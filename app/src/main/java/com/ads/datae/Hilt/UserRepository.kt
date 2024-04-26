package com.ads.datae.Hilt

import android.util.Log
import javax.inject.Inject

const val TAG = "MYHILTAPP"

class UserRepository @Inject constructor() {

    fun saveUser(email: String, passworld: String) {
        Log.e(TAG, "User Saved In DB")
    }
}