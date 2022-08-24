package com.james.curly.data.response.post_recommend

import com.james.curly.data.model.Product
import kotlin.random.Random

data class Item(
    val itemId: String,
)


fun Item.toProduct():Product{
    return Product(title = this.itemId, image = null, amount = (1500..15000).random())
}