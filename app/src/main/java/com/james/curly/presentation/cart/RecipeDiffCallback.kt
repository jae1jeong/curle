package com.james.curly.presentation.cart

import androidx.recyclerview.widget.DiffUtil
import com.james.curly.data.model.RecipeItem

object RecipeDiffCallback:DiffUtil.ItemCallback<RecipeItem>() {
    override fun areItemsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean {
        return oldItem.name == newItem.name
    }
}