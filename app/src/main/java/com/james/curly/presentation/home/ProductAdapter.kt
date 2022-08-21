package com.james.curly.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.james.curly.R
import com.james.curly.data.model.Product
import com.james.curly.databinding.ItemProductBinding

class ProductAdapter:ListAdapter<Product,ProductAdapter.ViewHolder>(ProductDiffCallback) {
    class ViewHolder(val binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_product,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.product = item

    }
}