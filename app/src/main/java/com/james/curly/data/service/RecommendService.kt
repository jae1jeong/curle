package com.james.curly.data.service

import com.james.curly.data.request.post_recommend.RecommendRequest
import com.james.curly.data.response.post_recommend.PostRecommendationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RecommendService {

    @POST("recommendations/")
    suspend fun postRecommend(@Body recommendRequest: RecommendRequest):PostRecommendationResponse
}