package com.james.curly.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val title:String,
    val image:String?,
    val amount:Int = 0
):Parcelable
