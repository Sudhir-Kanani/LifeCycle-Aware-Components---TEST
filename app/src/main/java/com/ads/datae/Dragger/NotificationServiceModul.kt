package com.ads.datae.Dragger

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class NotificationServiceModul {

    @Singleton
    @MessageQulifiler
    @Provides
    fun getMessageService (retryCount:Int):NotificationService{
        return MessageService(retryCount)
    }

    @EmailQulifiler
    @Provides
    fun getEmailService (emailService: EmailService):NotificationService{
        return emailService
    }
}