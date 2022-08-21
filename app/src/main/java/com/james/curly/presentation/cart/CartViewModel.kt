package com.james.curly.presentation.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.curly.data.model.CartItem
import com.james.curly.presentation.base.BaseViewModel

class CartViewModel : BaseViewModel() {
    val testItem = CartItem(id = 0,"대파","https://img-cf.kurly.com/cdn-cgi/image/width=400,format=auto/shop/data/goods/1582523311723l0.jpg", amount = 99000, count = 1)
    private val _carts = MutableLiveData<List<CartItem>>(listOf(testItem,testItem.copy(id = 1),testItem.copy(id = 2)))
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
    }

    fun plus(position:Int){
        carts.value?.let {
            it[position].count++
            _carts.value = carts.value
        }
    }

    fun minus(position:Int){
        carts.value?.let {
            it[position].count--
            _carts.value = carts.value
        }
    }

    fun deleteItem(position: Int) {
        _carts.value?.let {
            Log.d("TAG", "deleteItem: $position")
            val currentList = it.toMutableList()
            currentList.removeAt(position)
            _carts.value = currentList
        }

    }


}