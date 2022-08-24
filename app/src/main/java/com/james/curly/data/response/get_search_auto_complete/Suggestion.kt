package com.james.curly.data.response.get_search_auto_complete

data class Suggestion(
    val id: String,
    val score: Int,
    val suggestion: String
)