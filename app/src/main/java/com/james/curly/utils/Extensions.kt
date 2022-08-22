package com.james.curly.utils

import java.text.DecimalFormat


fun Int.toCurrencyFormat():String{
    val format = DecimalFormat("#,##0")
    return format.format(this)
}

fun String.toKrwFormat():String{
    return String.format("%s원",this)

}