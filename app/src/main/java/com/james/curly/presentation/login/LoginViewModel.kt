package com.james.curly.presentation.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.curly.domain.repository.AppDataRepository
import com.james.curly.presentation.base.BaseViewModel
import com.james.curly.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appDataRepository: AppDataRepository
): BaseViewModel() {
    var selectedId:String = ""
    private val _loginSuccessEvent  = SingleLiveEvent<Void>()
    val loginSuccessEvent:LiveData<Void> get() = _loginSuccessEvent


    fun signIn(view:View){
        if(selectedId.isNotEmpty()){
            appDataRepository.setUserId(selectedId)
            _loginSuccessEvent.call()
        }
    }
}