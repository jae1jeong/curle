package com.james.curly.data.model

data class Product(
    val id:Long,
    val title:String,
    val image:String?,
    val amount:Int = 0
)
