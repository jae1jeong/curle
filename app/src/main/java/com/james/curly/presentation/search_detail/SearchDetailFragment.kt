package com.james.curly.presentation.search_detail

import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.james.curly.R
import com.james.curly.data.model.Product
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.databinding.FragmentSearchDetailBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.presentation.base.ItemClickListener
import com.james.curly.presentation.home.ProductAdapter
import com.james.curly.utils.EventType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.android.widget.textChanges

@AndroidEntryPoint
class SearchDetailFragment : BaseFragment<FragmentSearchDetailBinding,SearchDetailViewModel>(R.layout.fragment_search_detail) {

    private val deviceId:String by lazy { Settings.Secure.getString(requireContext()?.contentResolver, Settings.Secure.ANDROID_ID) }
    private val viewModel:SearchDetailViewModel by viewModels()
    private val productAdapter = ProductAdapter(true)
    private val args:SearchDetailFragmentArgs by navArgs()
    private val activityViewModel:ActivityViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.etSearch.setText(args.keyword)
    }

    override fun initVIew() {
        val spaceSize = resources.getDimension(R.dimen.search_item_space)
        binding.rvSearchDetail.apply {
            adapter = productAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(),2)
            addItemDecoration(GridSpaceItemDecoration(spaceSize))
        }

        productAdapter.cartClickListener = object : ItemClickListener<Product> {
            override fun onClick(item: Product) {
                activityViewModel.postEvent(
                    EventRequest(
                        Event(itemId = item.title),
                        EventType.AddToCart.type,deviceId,activityViewModel.userId)
                )
            }
        }

        productAdapter.itemClickListener = object : ItemClickListener<Product> {
            override fun onClick(item: Product) {
                val action = SearchDetailFragmentDirections.actionSearchDetailFragmentToProductDetailFragment(item)
                findNavController().navigate(action)
            }
        }
    }

    override fun setEvent() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.etSearch.textChanges()
            .debounce(800)
            .onEach{
                w ->
                if(w.toString().isNotEmpty()){
                    viewModel.getSearch(w.toString())
                    activityViewModel.postEvent(EventRequest(Event(itemId = w.toString()),EventType.Search.type,deviceId,activityViewModel.userId))
                }else productAdapter.submitList(listOf())

            }.launchIn(lifecycleScope)
    }

    override fun observeData() {
        viewModel.products.observe(viewLifecycleOwner){
            productAdapter.submitList(it)
        }

        activityViewModel.postSuccessEvent.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

}