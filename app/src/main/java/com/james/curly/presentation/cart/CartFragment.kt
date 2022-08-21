package com.james.curly.presentation.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.curly.R
import com.james.curly.databinding.FragmentCartBinding
import com.james.curly.presentation.base.BaseFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint


class CartFragment : BaseFragment<FragmentCartBinding,CartViewModel>(R.layout.fragment_cart) {

    private val viewModel: CartViewModel by viewModels()


    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
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