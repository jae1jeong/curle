package com.james.curly.presentation.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.james.curly.R
import com.james.curly.databinding.ItemEventBinding
import reactivecircus.flowbinding.recyclerview.dataChanges

class EventAdapter:RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    var events = listOf<String>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    class ViewHolder(val binding:ItemEventBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.bind<ItemEventBinding>(LayoutInflater.from(parent.context).inflate(R.layout.item_event,parent,false))
        return ViewHolder(binding ?: throw NullPointerException())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = events[position]
        holder.binding.imgUrl = item

    }

    override fun getItemCount(): Int = events.size

}