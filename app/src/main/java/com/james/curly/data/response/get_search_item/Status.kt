package com.james.curly.data.response.get_search_item

import com.google.gson.annotations.SerializedName

data class Status(
    val rid: String,
    @SerializedName("time-ms")
    val timeMs: Int
)