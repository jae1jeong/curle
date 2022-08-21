package com.james.curly.presentation.product_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.curly.R
import com.james.curly.databinding.FragmentProductDetailBinding
import com.james.curly.presentation.base.BaseFragment

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding,ProductDetailViewModel>(R.layout.fragment_product_detail) {

    private val viewModel: ProductDetailViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun initVIew() {

    }

    override fun setEvent() {

    }

    override fun observeData() {

    }

}