package com.james.curly.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.james.curly.R
import com.james.curly.databinding.FragmentLoginBinding
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.base.BaseViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginViewModel>(R.layout.fragment_login) {

    private val viewModel:LoginViewModel by viewModels()

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