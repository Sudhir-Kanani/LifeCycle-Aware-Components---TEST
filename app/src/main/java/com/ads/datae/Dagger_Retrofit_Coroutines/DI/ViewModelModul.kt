package com.ads.datae.Dagger_Retrofit_Coroutines.DI

import androidx.lifecycle.ViewModel
import com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel.MainViewModel
import com.ads.datae.Dagger_Retrofit_Coroutines.ViewModel.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import org.jetbrains.annotations.NotNull

@Module
abstract class ViewModelModul {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun getViewModel1(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun getViewModel2(mainViewMode2: MainViewModel2) : ViewModel
}