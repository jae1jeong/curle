package com.james.curly.presentation.product_desc

import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.james.curly.R
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.databinding.FragmentProductDescBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.product_detail.ProductDetailFragment
import com.james.curly.utils.EventType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDescFragment : BaseFragment<FragmentProductDescBinding,ActivityViewModel>(R.layout.fragment_product_desc) {
    private val activityViewModel:ActivityViewModel by activityViewModels()
    private val deviceId:String by lazy { Settings.Secure.getString(requireContext()?.contentResolver, Settings.Secure.ANDROID_ID) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = activityViewModel
    }
    override fun initVIew() {

    }

    override fun setEvent() {
        binding.btnBuy.setOnClickListener {
            activityViewModel.postEvent(EventRequest(Event(itemId = activityViewModel.itemId),EventType.Purchase.type,deviceId,activityViewModel.userId))
        }
    }

    override fun observeData() {
        activityViewModel.postSuccessEvent.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }


}