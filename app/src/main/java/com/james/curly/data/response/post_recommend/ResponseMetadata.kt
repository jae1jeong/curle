package com.james.curly.data.response.post_recommend

import com.google.gson.annotations.SerializedName

data class ResponseMetadata(
    @SerializedName("HTTPHeaders")
    val httpHeaders: HTTPHeaders,
    @SerializedName("HTTPStatusCode")
    val httpStatusCode: Int,
    @SerializedName("RequestId")
    val requestId: String,
    @SerializedName("RetryAttempts")
    val retryAttempts: Int
)