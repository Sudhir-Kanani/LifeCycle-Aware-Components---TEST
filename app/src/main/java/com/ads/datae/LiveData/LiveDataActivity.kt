package com.ads.datae.LiveData

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ads.lifecycleawarecomponents.R

class LiveDataActivity : AppCompatActivity() {

    val btn_update: Button
        get() = findViewById(R.id.btn_update)


    val txt_data: TextView
        get() = findViewById(R.id.txt_data)

    lateinit var liveDataViewModel: LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        liveDataViewModel.liveData.observe(this, Observer {
            txt_data.text = it
        })

        btn_update.setOnClickListener {
            liveDataViewModel.updateData()
        }
    }
}