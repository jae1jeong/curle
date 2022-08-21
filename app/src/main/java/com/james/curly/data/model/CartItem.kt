package com.james.curly.data.model

data class CartItem(
    val id:Long,
    val title:String,
    val image:String?,
    var checked:Boolean = false,
    val amount:Int = 0,
    var count:Int = 1
)
