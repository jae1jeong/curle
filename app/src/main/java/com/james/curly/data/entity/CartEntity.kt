package com.james.curly.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.james.curly.data.model.CartItem


@Entity
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val image: String?,
    val amount: Int = 0
)


fun CartEntity.toCartItem() = CartItem(
    title = title, image = image, amount = amount
)

fun CartItem.toCartEntity() = CartEntity(
    id, title, image, amount
)