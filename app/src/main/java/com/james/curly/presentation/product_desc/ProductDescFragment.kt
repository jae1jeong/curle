package com.james.curly.presentation.product_desc

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.james.curly.R
import com.james.curly.databinding.FragmentProductDescBinding
import com.james.curly.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDescFragment : BaseFragment<FragmentProductDescBinding,ProductDescViewModel>(R.layout.fragment_product_desc) {
    private val viewModel:ProductDescViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
    override fun initVIew() {
        TODO("Not yet implemented")
    }

    override fun setEvent() {
        TODO("Not yet implemented")
    }

    override fun observeData() {
        TODO("Not yet implemented")
    }


}