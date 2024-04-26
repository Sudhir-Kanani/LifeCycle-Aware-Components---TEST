package com.ads.datae.dataAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("customisation")
fun ImageView.customisation(url : String)
{
    Glide.with(this.context).load(url).into(this)
}