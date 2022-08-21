package com.james.curly.presentation.recommend

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.curly.R
import com.james.curly.databinding.FragmentRecommendBinding
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.home.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.flow
import java.util.*

@AndroidEntryPoint
class RecommendFragment :
    BaseFragment<FragmentRecommendBinding, RecommendViewModel>(R.layout.fragment_recommend) {


    private val viewModel: RecommendViewModel by viewModels()
    private val recommendAdapter = ProductAdapter()
    private val beautyRecommendAdapter = ProductAdapter()
    private val eventAdapter = EventAdapter()
    private val eventAutoScrollTimer = Timer()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun initVIew() {
        binding.includeRecommend.rvRecommendProduct.apply {
            adapter = recommendAdapter
        }
        binding.includeRecommendBeauty.rvRecommendProduct.apply {
            adapter = beautyRecommendAdapter
        }

        binding.vp2Event.apply {
            adapter = eventAdapter
        }
        eventAdapter.events = listOf(
            "https://image.zdnet.co.kr/2019/05/17/hjan_v3YXVTtfayKHjZz.jpg",
            "https://image.zdnet.co.kr/2019/05/17/hjan_v3YXVTtfayKHjZz.jpg",
            "https://image.zdnet.co.kr/2019/05/17/hjan_v3YXVTtfayKHjZz.jpg"
        )
    }


    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun setEvent() {

    }

    override fun observeData() {

    }

}