package com.james.curly.presentation.home


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.james.curly.R
import com.james.curly.data.model.Product
import com.james.curly.databinding.FragmentHomeBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.best.BestFragment
import com.james.curly.presentation.event.EventFragment
import com.james.curly.presentation.new_product.NewProductFragment
import com.james.curly.presentation.recommend.RecommendFragment
import com.james.curly.presentation.shopping.ShoppingFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private lateinit var homeAdapter: HomeFragmentStateAdapter

    private val args: HomeFragmentArgs by navArgs()
    private val activityViewModel: ActivityViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activityViewModel.userId = args.userId
        homeAdapter = HomeFragmentStateAdapter(childFragmentManager, lifecycle)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initVIew() {
        binding.vp2.apply {
            adapter = homeAdapter
            isUserInputEnabled = false
        }
        homeAdapter.fragments = listOf(
            RecommendFragment(),
            NewProductFragment(),
            BestFragment(),
            ShoppingFragment(),
            EventFragment()
        )
        val tabTexts = listOf("컬리추천", "신상품", "베스트", "알뜰쇼핑", "특가/혜택")

        TabLayoutMediator(binding.tl, binding.vp2) { tab, index ->
            tab.text = tabTexts[index]
            when (index) {
                0 -> tab.view.isClickable = true
                else -> tab.view.isClickable = false
            }
        }.attach()
    }

    override fun setEvent() {
        binding.ivCart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCartFragment()
            findNavController().navigate(action)
        }
    }

    fun moveToDetailFragment(item: Product) {
        val action = HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(item)
        findNavController().navigate(action)
    }

    override fun observeData() {
    }
}