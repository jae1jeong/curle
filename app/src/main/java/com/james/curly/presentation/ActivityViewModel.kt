package com.james.curly.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.james.curly.data.entity.CartEntity
import com.james.curly.data.model.Product
import com.james.curly.data.request.post_events.Event
import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.domain.repository.AppDataRepository
import com.james.curly.domain.repository.CartRepository
import com.james.curly.domain.repository.EventRepository
import com.james.curly.presentation.base.BaseViewModel
import com.james.curly.utils.EventType
import com.james.curly.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val appDataRepository: AppDataRepository,
    private val cartRepository: CartRepository
):BaseViewModel() {

    var userId: String = ""

    var itemId:String = ""
    var currentProduct: Product?=null
    private val _postSuccessEvent = SingleLiveEvent<String>()
    val postSuccessEvent : LiveData<String> get() = _postSuccessEvent

    init {
        appDataRepository.getUserId()?.let {
            userId = it
        }
    }

    fun postEvent(event:EventRequest,amount:Int=0){

        viewModelScope.launch {
            try{
                if(userId.isNotEmpty()){
                    val response = eventRepository.postUserBehavior(event)
                    if(event.eventType == EventType.AddToCart.type){
                        cartRepository.addCart(CartEntity(title = event.event.itemId, image = null, amount = amount))
                        _postSuccessEvent.value = "성공적으로 카트에 추가되었습니다."
                    }else if(event.eventType == EventType.Purchase.type){
                        _postSuccessEvent.value = "성공적으로 구매하였습니다."
                    }

                }

            }catch (e:Exception){
                e.printStackTrace()
            }

        }
    }
}