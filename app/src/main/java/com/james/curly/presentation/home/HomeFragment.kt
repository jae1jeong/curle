package com.james.curly.presentation.home


import com.james.curly.R
import com.james.curly.databinding.FragmentHomeBinding
import com.james.curly.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {


    override fun initVIew() {

        binding.vp2.apply {

        }
    }

    override fun setEvent() {
    }

    override fun observeData() {
    }
}