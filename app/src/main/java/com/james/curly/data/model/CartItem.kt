package com.james.curly.data.model

data class CartItem(
    val id:Long?=null,
    val title:String,
    val image:String?,
    val amount:Int = 0
)
