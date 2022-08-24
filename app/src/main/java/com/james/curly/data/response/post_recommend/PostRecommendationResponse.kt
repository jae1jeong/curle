package com.james.curly.data.response.post_recommend

import com.google.gson.annotations.SerializedName

data class PostRecommendationResponse(
    @SerializedName("ResponseMetadata")
    val responseMetadata: ResponseMetadata,
    val itemList: List<Item>,
    val recommendationId: String
)