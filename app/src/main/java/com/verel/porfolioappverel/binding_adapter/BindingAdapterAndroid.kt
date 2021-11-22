package com.verel.porfolioappverel.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.verel.porfolioappverel.data.Portfolio

@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portfolio?) {
    data?.let {
        text = it.title
    }

}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portfolio) {
    load(data.image) {
        crossfade(1000)
    }
}
