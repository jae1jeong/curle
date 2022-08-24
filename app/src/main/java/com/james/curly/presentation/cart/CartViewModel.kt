package com.james.curly.presentation.cart

import android.util.Log
import androidx.lifecycle.*
import com.james.curly.data.entity.CartEntity
import com.james.curly.data.entity.toCartEntity
import com.james.curly.data.entity.toCartItem
import com.james.curly.data.model.CartItem
import com.james.curly.domain.repository.CartRepository
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
): BaseViewModel() {

    val carts : LiveData<List<CartEntity>>

    val totalCnt = MediatorLiveData<Int>()

    private val exceptionHandler = CoroutineExceptionHandler{_,exception ->
        exception.printStackTrace()
    }

    val totalAmount = MediatorLiveData<Int>()

    init {
        carts = cartRepository.getCarts().asLiveData()
        totalCnt.addSource(carts){
            totalCnt.value = it.size
        }

        totalAmount.addSource(carts){
            totalAmount.value = it.sumOf { it.amount }
        }
    }


    fun updateItem(cartItem: CartItem){
        viewModelScope.launch {
            cartRepository.updateCart(cartItem.toCartEntity())
        }
    }


    fun deleteItem(cartItem: CartItem) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            cartRepository.deleteCart(cartItem.toCartEntity())
        }
    }


}