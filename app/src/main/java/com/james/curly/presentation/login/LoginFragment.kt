package com.james.curly.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.james.curly.R
import com.james.curly.databinding.FragmentLoginBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.base.BaseViewModel
import com.james.curly.presentation.recommend.RecommendViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding,LoginViewModel>(R.layout.fragment_login) {

    private val viewModel:LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun initVIew() {
        val items = resources.getStringArray(R.array.id_array)
        val spinnerAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,items)
        binding.spId.adapter = spinnerAdapter
        binding.spId.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.selectedId = items[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    override fun setEvent() {
    }

    override fun observeData() {
        viewModel.loginSuccessEvent.observe(viewLifecycleOwner){
            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(viewModel.selectedId)
            findNavController().navigate(action)
        }
    }
}