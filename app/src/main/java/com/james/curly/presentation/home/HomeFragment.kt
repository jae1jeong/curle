package com.james.curly.presentation.home


import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.james.curly.R
import com.james.curly.databinding.FragmentHomeBinding
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.best.BestFragment
import com.james.curly.presentation.event.EventFragment
import com.james.curly.presentation.new_product.NewProductFragment
import com.james.curly.presentation.recommend.RecommendFragment
import com.james.curly.presentation.shopping.ShoppingFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {

    private val homeAdapter by lazy { HomeFragmentStateAdapter(requireActivity()) }


    override fun initVIew() {

        binding.vp2.apply {
            adapter = homeAdapter
        }
        homeAdapter.fragments = listOf(RecommendFragment(),NewProductFragment(),BestFragment(),ShoppingFragment(),EventFragment())
        val tabTexts = listOf<String>("컬리추천","신상품","베스트","알뜰쇼핑","특가/혜택")

        TabLayoutMediator(binding.tl,binding.vp2){
            tab,index ->
            tab.text = tabTexts[index]
        }.attach()
    }

    override fun setEvent() {

        binding.ivCart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCartFragment()
            findNavController().navigate(action)
        }
    }

    override fun observeData() {
    }
}