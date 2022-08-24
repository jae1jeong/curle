package com.james.curly.domain.repository

import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.data.response.post_event.PostEventResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EventRepository {

    suspend fun postUserBehavior(eventRequest: EventRequest): PostEventResponse
}