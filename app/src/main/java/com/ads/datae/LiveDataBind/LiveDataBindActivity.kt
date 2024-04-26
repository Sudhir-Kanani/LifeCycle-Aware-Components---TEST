package com.ads.datae.LiveDataBind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ads.datae.LivedataViewmodel
import com.ads.lifecycleawarecomponents.R
import com.ads.lifecycleawarecomponents.databinding.ActivityLiveDataBindBinding

class LiveDataBindActivity : AppCompatActivity() {
   lateinit var binding:ActivityLiveDataBindBinding
    lateinit var livedataViewmodel: LivedataViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_live_data_bind)
        livedataViewmodel = ViewModelProvider(this).get(LivedataViewmodel::class.java)

        binding.livedataviewmodel = livedataViewmodel

        binding.lifecycleOwner = this
    }
}