package com.ads.datae.Dragger

import androidx.transition.Visibility.Mode
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UserRepsitroyModul {

//    @Provides
//    fun getFirebaseReposirory():UserRepository
//    {
//        return FirebaseRepository()
//    }

    @Binds
    @Singleton
    abstract fun getSQLReposirory(sqlRepository: SQLRepository):UserRepository
}