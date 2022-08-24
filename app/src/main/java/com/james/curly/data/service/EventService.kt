package com.james.curly.data.service

import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.data.response.post_event.PostEventResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EventService {

    @POST("events/")
    suspend fun postUserBehavior(@Body eventRequest: EventRequest):PostEventResponse
}