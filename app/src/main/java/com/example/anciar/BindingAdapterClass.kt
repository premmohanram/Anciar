package com.example.anciar

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("text")
 fun TextView.text(text: String) {
    this.text = this.context.resources.getString(R.string.section,text)
}


