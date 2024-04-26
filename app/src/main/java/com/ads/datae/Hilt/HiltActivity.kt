package com.ads.datae.Hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ads.lifecycleawarecomponents.R
//import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {
    @Inject
    lateinit var userRepository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        userRepository.saveUser("test@gmail.com","11111")
    }
}