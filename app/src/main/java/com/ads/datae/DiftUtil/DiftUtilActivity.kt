package com.ads.datae.DiftUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ads.lifecycleawarecomponents.R

class DiftUtilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dift_util)

        val programiclist = findViewById<RecyclerView>(R.id.programiclist)


        val linerlayoutMananger = LinearLayoutManager(this)

        programiclist.layoutManager = linerlayoutMananger
        programiclist.setHasFixedSize(true)

        val programicAdapter = ProgramicAdapter()

        val p1 = ProgramicItem(1,"A","Android")
        val p2 = ProgramicItem(2,"J","Java")
        val p3 = ProgramicItem(3,"K","Kotline")

        programicAdapter.submitList(listOf(p1,p2,p3))

        programiclist.adapter = programicAdapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val p3 = ProgramicItem(3,"K","Kotline")
            val p4 = ProgramicItem(4,"R","Ruby")
            val p5 = ProgramicItem(5,"P","Python")
            val p6 = ProgramicItem(6,"C","C")
            val p7 = ProgramicItem(7,"P","Php")

            programicAdapter.submitList(listOf(p3,p4,p5,p6,p7))


        },4000)

    }
}