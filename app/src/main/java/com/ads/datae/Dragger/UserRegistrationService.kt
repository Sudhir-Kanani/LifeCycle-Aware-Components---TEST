package com.ads.datae.Dragger

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQulifiler private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "sk123@gmail.com", "User register")
    }
}