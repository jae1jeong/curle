package com.james.curly.data.repository

import com.james.curly.data.request.post_recommend.RecommendRequest
import com.james.curly.data.response.post_recommend.PostRecommendationResponse
import com.james.curly.data.service.RecommendService
import com.james.curly.domain.repository.RecommendRepository
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
    private val recommendService: RecommendService
):RecommendRepository {
    override suspend fun postRecommend(recommendRequest: RecommendRequest): PostRecommendationResponse {
        return recommendService.postRecommend(recommendRequest)
    }

}