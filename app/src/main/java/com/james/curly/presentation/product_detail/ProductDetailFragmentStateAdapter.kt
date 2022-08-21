package com.james.curly.presentation.product_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.james.curly.presentation.product_desc.ProductDescFragment
import com.james.curly.presentation.product_info.ProductInfoFragment
import com.james.curly.presentation.product_qna.ProductQnaFragment
import com.james.curly.presentation.product_review.ProductReviewFragment

class ProductDetailFragmentStateAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
    var fragments = listOf<Fragment>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ProductDescFragment()
            1 -> ProductInfoFragment()
            2 -> ProductReviewFragment()
            3 -> ProductQnaFragment()
            else -> throw IllegalArgumentException()
        }
    }
}