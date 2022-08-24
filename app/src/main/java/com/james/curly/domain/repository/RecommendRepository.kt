package com.james.curly.domain.repository

import com.james.curly.data.request.post_recommend.RecommendRequest
import com.james.curly.data.response.post_recommend.PostRecommendationResponse
import retrofit2.http.Body


interface RecommendRepository {
    suspend fun postRecommend(recommendRequest: RecommendRequest): PostRecommendationResponse
}