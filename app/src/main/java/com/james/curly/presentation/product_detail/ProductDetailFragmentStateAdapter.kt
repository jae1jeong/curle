package com.james.curly.presentation.product_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProductDetailFragmentStateAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
    var fragments = listOf<Fragment>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when(position){

        }
    }
}