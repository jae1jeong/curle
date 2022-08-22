package com.james.curly.presentation.cart

import android.util.Log
import androidx.lifecycle.*
import com.james.curly.data.entity.toCartEntity
import com.james.curly.data.entity.toCartItem
import com.james.curly.data.model.CartItem
import com.james.curly.domain.repository.CartRepository
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
): BaseViewModel() {
    val t1 = CartItem(id = 0,"대파","https://img-cf.kurly.com/cdn-cgi/image/width=400,format=auto/shop/data/goods/1582523311723l0.jpg", amount = 99000, count = 1)
    val t2 = CartItem(id = 0,"대파","https://img-cf.kurly.com/cdn-cgi/image/width=400,format=auto/shop/data/goods/1582523311723l0.jpg", amount = 99000, count = 1)
    val t3 = CartItem(id = 0,"대파","https://img-cf.kurly.com/cdn-cgi/image/width=400,format=auto/shop/data/goods/1582523311723l0.jpg", amount = 99000, count = 1)

    private val _carts = MutableLiveData<List<CartItem>>(listOf(t1,t2,t3))
    val carts : LiveData<List<CartItem>> get() = _carts

    val currentCheckCnt = MediatorLiveData<Int>()
    val totalCnt = MediatorLiveData<Int>()

    init {
        currentCheckCnt.addSource(carts){
            currentCheckCnt.value = it.count { it.checked }
        }
        totalCnt.addSource(carts){
            totalCnt.value = it.size
        }

        getCarts()
    }

    private fun getCarts(){
        _carts.value = cartRepository.getCarts().asLiveData(Dispatchers.Main).value?.map {
            it.toCartItem()
        }
    }

    fun plus(position:Int){
        carts.value?.let {
            it[position].count++
            _carts.value = carts.value
            viewModelScope.launch(Dispatchers.IO) {
                cartRepository.updateCart(it[position].toCartEntity())
            }
        }
    }

    fun minus(position:Int){
        carts.value?.let {
            it[position].count--
            _carts.value = carts.value
            viewModelScope.launch(Dispatchers.IO) {
                cartRepository.updateCart(it[position].toCartEntity())
            }
        }
    }

    fun deleteItem(position: Int) {
        _carts.value!!.let {
            val currentList = it.toMutableList()
            currentList.removeAt(position)
            _carts.value = currentList
            viewModelScope.launch(Dispatchers.IO) {
                cartRepository.deleteCart(it[position].toCartEntity())
            }
        }
    }


}