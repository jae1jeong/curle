package com.james.curly.presentation.search

import androidx.recyclerview.widget.DiffUtil
import com.james.curly.data.model.SearchKeywordItem

object SearchKeywordDiffCallback:DiffUtil.ItemCallback<SearchKeywordItem>() {
    override fun areItemsTheSame(oldItem: SearchKeywordItem, newItem: SearchKeywordItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SearchKeywordItem,
        newItem: SearchKeywordItem
    ): Boolean {
        return oldItem.text == newItem.text
    }
}