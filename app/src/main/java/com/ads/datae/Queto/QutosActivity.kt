package com.ads.datae.Queto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ads.lifecycleawarecomponents.R
import com.ads.lifecycleawarecomponents.databinding.ActivityQutossBinding

class   QutosActivity : AppCompatActivity() {
    val txt_quetos: TextView
        get() = findViewById(R.id.txt_quetos)

    val txt_author:TextView
        get() = findViewById(R.id.txt_author)

    lateinit var quetosViewModel:QuetosViewModel

    lateinit var dataBinding: ActivityQutossBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_qutoss)
//        setContentView(R.layout.activity_qutos)

        quetosViewModel = ViewModelProvider(this,QuetosViewModelFactory(applicationContext)).get(QuetosViewModel::class.java)

        dataBinding.quetos = quetosViewModel.getText()


    }
    fun SetText()
    {
        val  quetos =  quetosViewModel.getText()
        txt_quetos.text   = quetos.text
        txt_author.text   = quetos.author
    }

    fun Previous(view: View) {
        val  quetos =  quetosViewModel.getPreviousText()

        txt_quetos.text   = quetos.text
        txt_author.text   = quetos.author
    }
    fun Next(view: View) {
        val  quetos =  quetosViewModel.getNextText()

        txt_quetos.text   = quetos.text
        txt_author.text   = quetos.author
    }
}