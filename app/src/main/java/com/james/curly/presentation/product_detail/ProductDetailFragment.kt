package com.james.curly.presentation.product_detail

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.james.curly.R
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.databinding.FragmentProductDetailBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.home.HomeFragmentArgs
import com.james.curly.presentation.product_desc.ProductDescFragment
import com.james.curly.presentation.product_info.ProductInfoFragment
import com.james.curly.presentation.product_qna.ProductQnaFragment
import com.james.curly.presentation.product_review.ProductReviewFragment
import com.james.curly.utils.EventType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding,ProductDetailViewModel>(R.layout.fragment_product_detail) {

    private val viewModel: ProductDetailViewModel by viewModels()
    private lateinit var fragmentStateAdapter:ProductDetailFragmentStateAdapter
    private val activityViewModel:ActivityViewModel by activityViewModels()
    private val deviceId:String by lazy { Settings.Secure.getString(requireContext().contentResolver, Settings.Secure.ANDROID_ID) }
    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentStateAdapter = ProductDetailFragmentStateAdapter(requireActivity())
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val product = args.product
        activityViewModel.currentProduct = product
        activityViewModel.postEvent(EventRequest(Event(itemId = product.title),EventType.View.type,deviceId,activityViewModel.userId))
    }

    override fun initVIew() {
        binding.vp2.apply {
            adapter = fragmentStateAdapter
            isUserInputEnabled = false
        }
        fragmentStateAdapter.fragments = listOf(ProductDescFragment(),ProductInfoFragment(),ProductReviewFragment(),ProductQnaFragment())

    }

    override fun setEvent() {
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    override fun observeData() {

    }
}