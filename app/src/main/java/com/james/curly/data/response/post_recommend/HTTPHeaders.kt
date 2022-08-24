package com.james.curly.data.response.post_recommend

import com.google.gson.annotations.SerializedName

data class HTTPHeaders(
    val connection: String,
    @SerializedName("content-length")
    val contentLength: String,
    @SerializedName("content-type")
    val contentType: String,
    val date: String,
    @SerializedName("x-amzn-requestid")
    val xAmznRequestid: String
)