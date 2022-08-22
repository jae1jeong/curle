package com.james.curly.presentation.cart

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.james.curly.R
import com.james.curly.data.model.CartItem
import com.james.curly.databinding.ItemCartBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class CartItemAdapter @Inject constructor(private val viewModel:CartViewModel):ListAdapter<CartItem,CartItemAdapter.ViewHolder>(CartDiffCallback) {
    inner class ViewHolder(val binding:ItemCartBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemCartBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_cart,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.cart = item

        holder.binding.checkBox.setOnClickListener {
            item.checked = holder.binding.checkBox.isChecked
            notifyItemChanged(position)
        }

        holder.binding.btnPlus.setOnClickListener {
            viewModel.plus(position)
            notifyItemChanged(position)
        }

        holder.binding.btnMinus.setOnClickListener {
            viewModel.minus(position)
            notifyItemChanged(position)
        }

        holder.binding.btnDelete.setOnClickListener {
            viewModel.deleteItem(position)
            notifyItemRemoved(position)
        }
    }
}