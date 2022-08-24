package com.james.curly.data.repository

import com.google.gson.JsonObject
import com.james.curly.data.response.get_search_auto_complete.GetSearchAutoCompleteResponse
import com.james.curly.data.response.get_search_item.GetSearchItemResponse
import com.james.curly.data.service.SearchService
import com.james.curly.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchService: SearchService
):SearchRepository {
    override suspend fun getSearchItems(word: String): GetSearchItemResponse {
        return searchService.getSearchItems(word)
    }

    override suspend fun getAutoComplete(word: String, suggester: String): GetSearchAutoCompleteResponse {
        return searchService.getAutoComplete(word,suggester)
    }
}