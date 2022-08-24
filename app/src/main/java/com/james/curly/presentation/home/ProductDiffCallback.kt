package com.james.curly.presentation.home

import androidx.recyclerview.widget.DiffUtil
import com.james.curly.data.model.Product

object ProductDiffCallback:DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.title == newItem.title
    }
}