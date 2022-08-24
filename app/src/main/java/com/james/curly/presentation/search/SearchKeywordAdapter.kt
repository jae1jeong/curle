package com.james.curly.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.james.curly.R
import com.james.curly.data.model.SearchKeywordItem
import com.james.curly.databinding.ItemProductSearchBinding

class SearchKeywordAdapter:ListAdapter<SearchKeywordItem,SearchKeywordAdapter.ViewHolder>(SearchKeywordDiffCallback) {
    class ViewHolder(val binding:ItemProductSearchBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemProductSearchBinding>(LayoutInflater.from(parent.context),
            R.layout.item_product_search,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
    }
}


