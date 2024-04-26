package com.ads.datae.Dagger_Retrofit_Coroutines.DI

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ads.datae.Dagger_Retrofit_Coroutines.Dagger_Retrofit_Coroutines_Activity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModul::class,DatabaseModul::class, ViewModelModul::class])
interface ApplicationComponent {
    fun inject(daggerRetrofitCoroutinesActivity: Dagger_Retrofit_Coroutines_Activity)

    fun getMap():Map<Class<*>,ViewModel>

    @Component.Factory
    interface factory
    {
        fun create(@BindsInstance context: Context):ApplicationComponent
    }
}