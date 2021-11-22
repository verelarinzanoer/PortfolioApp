package com.verel.porfolioappverel.binding_adapter

import android.widget.TextView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.verel.porfolioappverel.data.Portfolio

@BindingAdapter("experienceTitle")
fun TextView.setExperienceTitle(data: Portfolio?){
    data?.let {
        text = data.title
    }
}

@BindingAdapter("experienceDetail")
fun TextView.setExperienceDetail(data: Portfolio?){
    data?.let {
        text = data.detail
    }
}

@BindingAdapter("experienceImage")
fun ImageView.setExperienceImage(data: Portfolio){
    load(data.image) {
        crossfade(1000)
    }
}