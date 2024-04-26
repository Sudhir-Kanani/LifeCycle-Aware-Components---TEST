package com.ads.datae.dataAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ads.lifecycleawarecomponents.R
import com.ads.lifecycleawarecomponents.databinding.ActivityDataAdapterBinding

class BindAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_adapter)

        val dataAdapter = BindAdapter("demo",
            "https://st.depositphotos.com/1009050/2176/i/600/depositphotos_21761349-stock-photo-nice-sunset-on-lake.jpg")

        binding.datadapter = dataAdapter
    }
}