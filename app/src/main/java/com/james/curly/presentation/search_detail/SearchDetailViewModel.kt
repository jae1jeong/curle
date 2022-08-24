package com.james.curly.presentation.search_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.james.curly.data.model.Product
import com.james.curly.domain.repository.SearchRepository
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchDetailViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : BaseViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products:LiveData<List<Product>> get() = _products

    fun getSearch(word:String){
        viewModelScope.launch {
            try{
                val response = searchRepository.getSearchItems(word)
                _products.value = response.hits.hit.map {
                    Product(
                        title = it.fields.item_id,
                        amount = it.fields.price.toInt(),
                        image = null
                    )
                }

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}