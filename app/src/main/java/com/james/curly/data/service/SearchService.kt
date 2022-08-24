package com.james.curly.data.service

import com.google.gson.JsonObject
import com.james.curly.data.response.get_search_auto_complete.GetSearchAutoCompleteResponse
import com.james.curly.data.response.get_search_item.GetSearchItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search")
    suspend fun getSearchItems(@Query("q") word:String): GetSearchItemResponse

    @GET("suggest")
    suspend fun getAutoComplete(@Query("q") word:String,@Query("suggester") suggester:String = "itemsuggest"):GetSearchAutoCompleteResponse

}