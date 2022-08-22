package com.james.curly.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

object StringBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:currencyFormat")
    fun toKrwCurrencyFormat(textView: TextView,currencyAmount:Int){
        textView.text = currencyAmount.toCurrencyFormat().toKrwFormat()
    }
}