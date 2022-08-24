package com.james.curly.data.response.get_search_auto_complete

data class GetSearchAutoCompleteResponse(
    val status: Status,
    val suggest: Suggest
)