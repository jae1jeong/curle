package com.james.curly.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.james.curly.presentation.best.BestFragment
import com.james.curly.presentation.event.EventFragment
import com.james.curly.presentation.new_product.NewProductFragment
import com.james.curly.presentation.recommend.RecommendFragment
import com.james.curly.presentation.shopping.ShoppingFragment

class HomeFragmentStateAdapter(fm:FragmentManager,lifecycle:Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    var fragments = listOf<Fragment>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RecommendFragment()
            1 -> NewProductFragment()
            2 -> BestFragment()
            3 -> ShoppingFragment()
            4 -> EventFragment()
            else -> throw IllegalArgumentException()
        }
    }
}