package com.james.curly.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.james.curly.data.model.SearchKeywordItem
import com.james.curly.domain.repository.SearchRepository
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
): BaseViewModel() {

    private val _keywords = MutableLiveData<List<SearchKeywordItem>>()
    val keywords :LiveData<List<SearchKeywordItem>>get() = _keywords


    fun searchAutoComplete(word:String){
        viewModelScope.launch {
            try{
                val response =  searchRepository.getAutoComplete(word)
                _keywords.value = response.suggest.suggestions?.map { SearchKeywordItem(it.id,it.suggestion) }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}