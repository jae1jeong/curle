package com.james.curly.presentation

import androidx.lifecycle.viewModelScope
import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor():BaseViewModel() {
    fun initDynamoDB() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){

            }

        }

    }
}