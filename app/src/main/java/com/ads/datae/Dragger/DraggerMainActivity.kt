package com.ads.datae.Dragger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ads.datae.MyApplicaton
import com.ads.lifecycleawarecomponents.R
import javax.inject.Inject

class DraggerMainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragger_main)


        //manually DI
//        val userRepository = UserRepository()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepository,emailService)


//        val componet = DaggerUserRegistrationComponet.builder().build()
        val componet = (application as MyApplicaton).userRegistrationComponet

        // Constrator Injection
//        val userRegistrationService = componet.getUserRegistrationService()
//        val emailService = componet.getEmailService()


        // Field Injection
        componet.inject(this)

        userRegistrationService.registerUser("sk123@gmail.com", "12345")
    }
}