package com.james.curly.data.response.get_search_item

data class Hits(
    val found: Int,
    val hit: List<Hit>,
    val start: Int
)