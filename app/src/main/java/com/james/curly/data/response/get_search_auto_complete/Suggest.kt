package com.james.curly.data.response.get_search_auto_complete

data class Suggest(
    val found: Int,
    val query: String,
    val suggestions: List<Suggestion>?= emptyList()
)