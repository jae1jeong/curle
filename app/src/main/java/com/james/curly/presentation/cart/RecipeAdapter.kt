package com.james.curly.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.james.curly.R
import com.james.curly.data.model.RecipeItem
import com.james.curly.databinding.ItemRecipeBinding

class RecipeAdapter:ListAdapter<RecipeItem,RecipeAdapter.ViewHolder>(RecipeDiffCallback) {
    class ViewHolder(val binding:ItemRecipeBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemRecipeBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_recipe,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.recipe = item

    }
}