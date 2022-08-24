package com.james.curly.presentation.init_navigate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.james.curly.R
import com.james.curly.domain.repository.AppDataRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class InitNavigateFragment : Fragment() {

    @Inject lateinit var appDataRepository: AppDataRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val userId = appDataRepository.getUserId()
        if(userId.isNullOrEmpty()){
            val action = InitNavigateFragmentDirections.actionInitNavigateFragmentToLoginFragment()
            findNavController().navigate(action)
        }else{
            val action = InitNavigateFragmentDirections.actionInitNavigateFragmentToHomeFragment(userId)
            findNavController().navigate(action)
        }
        return inflater.inflate(R.layout.fragment_init_navigate, container, false)
    }

}