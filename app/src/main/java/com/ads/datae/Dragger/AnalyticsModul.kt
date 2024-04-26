package com.ads.datae.Dragger

import dagger.Module
import dagger.Provides

@Module
class AnalyticsModul {

    @Provides
    fun getAnalyticsService() : AnalysticsService
    {
        return  Mixpanal()
    }
}