package com.ads.datae.Queto

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ads.datae.Quetos
import com.google.gson.Gson

class QuetosViewModel(val context: Context) : ViewModel() {
    var quetos : Array<Quetos> = emptyArray()
    var index:Int = 0
    init {
        quetos = getQuetosFormAssets()

    }
    private fun getQuetosFormAssets(): Array<Quetos> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return  gson.fromJson(json,Array<Quetos>::class.java)
    }
    fun  getText() : Quetos
    {
        return quetos[index]
    }
    fun  getPreviousText() : Quetos
    {
        if (--index<0)
        {
            index = 1
        }

        return quetos[--index]
    }
    fun  getNextText() : Quetos
    {
        if (++index>=quetos.size)
        {
            index = quetos.size-1
        }

        return quetos[++index]
    }

}