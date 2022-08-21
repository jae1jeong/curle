package com.james.curly.presentation.cart

import androidx.recyclerview.widget.DiffUtil
import com.james.curly.data.model.CartItem

object CartDiffCallback:DiffUtil.ItemCallback<CartItem>() {
    override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem == newItem
    }

}