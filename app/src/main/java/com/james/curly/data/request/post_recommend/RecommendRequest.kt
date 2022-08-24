package com.james.curly.data.request.post_recommend

data class RecommendRequest(
    val userId:String,
    val filterArn:String,
    val type_recommend:String,
    val age:Int?=null,
    val gender:String?=null
)
