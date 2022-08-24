package com.james.curly.data.response.post_event

import com.google.gson.annotations.SerializedName

data class PostEventResponse(
    @SerializedName("SequenceNumber")
    val sequenceNumber: String,
    @SerializedName("ShardId")
    val shardId: String
)