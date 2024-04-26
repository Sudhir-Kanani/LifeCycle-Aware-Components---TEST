package com.ads.datae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ads.lifecycleawarecomponents.R

class MainActivity : AppCompatActivity() {

    lateinit var textinput_counter:TextView
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(observer())

        mainViewModel = ViewModelProvider(this,MianViewModelFactory(10)).get(MainViewModel::class.java)

        textinput_counter = findViewById(R.id.textinput_counter);
        setText()

        Log.d("CALLMETHOD  : ","Activity == > onCreate")

    }

    override fun onResume() {
        super.onResume()
        Log.d("CALLMETHOD  : ","Activity == > onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("CALLMETHOD  : ","Activity == > onPause")

    }
    fun increment(v: View)
    {
        mainViewModel.increment()
        setText()
    }
    fun setText()
    {
        textinput_counter.text = mainViewModel.count.toString()
    }
}