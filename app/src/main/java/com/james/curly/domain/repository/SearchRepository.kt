package com.james.curly.domain.repository

import com.google.gson.JsonObject
import com.james.curly.data.response.get_search_auto_complete.GetSearchAutoCompleteResponse
import com.james.curly.data.response.get_search_item.GetSearchItemResponse

interface SearchRepository {

    suspend fun getSearchItems(word:String): GetSearchItemResponse
    suspend fun getAutoComplete(word:String,suggester:String = "itemsuggest"): GetSearchAutoCompleteResponse

}