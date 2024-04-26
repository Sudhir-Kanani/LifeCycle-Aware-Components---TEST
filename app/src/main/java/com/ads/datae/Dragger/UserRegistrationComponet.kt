package com.ads.datae.Dragger

import android.text.Editable.Factory
import com.ads.datae.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepsitroyModul::class, NotificationServiceModul::class, AnalyticsModul::class])
interface UserRegistrationComponet {
//    fun getUserRegistrationService():UserRegistrationService
//    fun getEmailService():EmailService

    fun inject(mainActivity: DraggerMainActivity)

    @Component.Factory
    interface Factory
    {
        fun creare(@BindsInstance retryCount:Int) : UserRegistrationComponet
    }
}