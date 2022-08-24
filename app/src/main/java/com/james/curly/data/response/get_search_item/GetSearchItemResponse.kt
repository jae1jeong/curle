package com.james.curly.data.response.get_search_item

data class GetSearchItemResponse(
    val hits: Hits,
    val status: Status
)