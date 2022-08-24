package com.james.curly.presentation.recommend

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.james.curly.BuildConfig
import com.james.curly.R
import com.james.curly.data.model.Product
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.data.response.post_recommend.toProduct
import com.james.curly.databinding.FragmentRecommendBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.base.ItemClickListener
import com.james.curly.presentation.home.HomeFragment
import com.james.curly.presentation.home.ProductAdapter
import com.james.curly.utils.EventType
import com.james.curly.utils.SpaceDecoration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecommendFragment :
    BaseFragment<FragmentRecommendBinding, RecommendViewModel>(R.layout.fragment_recommend) {

    private val deviceId:String by lazy { Settings.Secure.getString(requireContext()?.contentResolver, Settings.Secure.ANDROID_ID) }
    private val viewModel: RecommendViewModel by viewModels()
    private val recommendAdapter = ProductAdapter()
    private val beautyRecommendAdapter = ProductAdapter()
    private val activityViewModel : ActivityViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        if(activityViewModel.userId.isNotEmpty()){
            viewModel.getRecommendItems(activityViewModel.userId,"personalize")
            viewModel.getRecommendItems(activityViewModel.userId,"beauty")
        }

    }

    override fun initVIew() {
        val itemSpaceSize = resources.getDimensionPixelSize(R.dimen.recommend_item_space)

        recommendAdapter.cartClickListener = object :ItemClickListener<Product>{
            override fun onClick(item: Product) {
                activityViewModel.postEvent(EventRequest(Event(itemId = item.title),EventType.AddToCart.type,deviceId,activityViewModel.userId),item.amount)
            }
        }

        recommendAdapter.itemClickListener = object : ItemClickListener<Product>{
            override fun onClick(item: Product) {
                (this@RecommendFragment.parentFragment as HomeFragment).moveToDetailFragment(item)
            }

        }
        beautyRecommendAdapter.cartClickListener = object :ItemClickListener<Product>{
            override fun onClick(item: Product) {
                activityViewModel.postEvent(EventRequest(Event(itemId = item.title),EventType.AddToCart.type,deviceId,activityViewModel.userId),item.amount)
            }
        }

        beautyRecommendAdapter.itemClickListener = object : ItemClickListener<Product>{
            override fun onClick(item: Product) {
                (this@RecommendFragment.parentFragment as HomeFragment).moveToDetailFragment(item)
            }
        }
        binding.includeRecommend.rvRecommendProduct.apply {
            adapter = recommendAdapter
            addItemDecoration(SpaceDecoration(mRight = itemSpaceSize))
            setHasFixedSize(true)
        }
        binding.includeRecommendBeauty.rvRecommendProduct.apply {
            adapter = beautyRecommendAdapter
            addItemDecoration(SpaceDecoration(mRight = itemSpaceSize))
            setHasFixedSize(true)
        }
    }


    override fun setEvent() {

    }

    override fun observeData() {
        viewModel.firstRecommendItems.observe(viewLifecycleOwner){
            recommendAdapter.submitList(it.map { it.toProduct() })
        }
        viewModel.secondRecommendItems.observe(viewLifecycleOwner){
            beautyRecommendAdapter.submitList(it.map { it.toProduct() })
        }

        activityViewModel.postSuccessEvent.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }


}