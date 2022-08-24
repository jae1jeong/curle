package com.james.curly.presentation.search

import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.james.curly.R
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.databinding.FragmentSearchBinding
import com.james.curly.presentation.ActivityViewModel
import com.james.curly.presentation.base.BaseFragment
import com.james.curly.utils.EventType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.android.widget.textChanges


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding,SearchViewModel>(R.layout.fragment_search) {
    private val deviceId:String by lazy { Settings.Secure.getString(requireContext()?.contentResolver, Settings.Secure.ANDROID_ID) }
    private val viewModel:SearchViewModel by viewModels()
    private val activityViewModel:ActivityViewModel by activityViewModels()
    private val searchKeywordAdapter = SearchKeywordAdapter()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel

    }

    override fun initVIew() {
        val dividerItemDecoration = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        binding.rvSearch.apply {
            adapter = searchKeywordAdapter
            setHasFixedSize(true)
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun setEvent() {
        binding.etSearch.textChanges()
            .debounce(800)
            .onEach { w ->
                if(w.toString().isNotEmpty()){
                    viewModel.searchAutoComplete(w.toString())
                    activityViewModel.postEvent(EventRequest(Event(itemId = w.toString()),EventType.Search.type,deviceId,activityViewModel.userId))
                }else{
                    searchKeywordAdapter.submitList(listOf())
                }
            }
            .launchIn(lifecycleScope)

        binding.btnSearch.setOnClickListener {
            if(binding.etSearch.text.toString().isNotEmpty()){
                val action = SearchFragmentDirections.actionSearchFragmentToSearchDetailFragment(binding.etSearch.text.toString())
                findNavController().navigate(action)
            }
        }
    }

    override fun observeData() {
        viewModel.keywords.observe(viewLifecycleOwner){
            searchKeywordAdapter.submitList(it)
        }
    }

}