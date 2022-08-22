package com.james.curly.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.james.curly.data.model.CartItem


@Entity
data class CartEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val image: String?,
    var checked: Boolean = false,
    val amount: Int = 0,
    var count: Int = 1
    )


fun CartEntity.toCartItem() = CartItem(
    id, title, image, checked, amount, count
)

fun CartItem.toCartEntity() = CartEntity(
    id, title, image, checked, amount, count
)