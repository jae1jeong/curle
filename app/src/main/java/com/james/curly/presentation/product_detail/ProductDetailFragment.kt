package com.james.curly.presentation.product_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.james.curly.R
import com.james.curly.databinding.FragmentProductDetailBinding
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.product_desc.ProductDescFragment
import com.james.curly.presentation.product_info.ProductInfoFragment
import com.james.curly.presentation.product_qna.ProductQnaFragment
import com.james.curly.presentation.product_review.ProductReviewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding,ProductDetailViewModel>(R.layout.fragment_product_detail) {

    private val viewModel: ProductDetailViewModel by viewModels()
    private val fragmentStateAdapter by lazy { ProductDetailFragmentStateAdapter(requireActivity()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun initVIew() {
        binding.vp2.apply {
            adapter = fragmentStateAdapter
        }
        fragmentStateAdapter.fragments = listOf(ProductDescFragment(),ProductInfoFragment(),ProductReviewFragment(),ProductQnaFragment())
    }

    override fun setEvent() {
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    override fun observeData() {

    }

}