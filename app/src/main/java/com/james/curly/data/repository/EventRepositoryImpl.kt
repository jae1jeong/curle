package com.james.curly.data.repository

import com.james.curly.data.request.post_events.EventRequest
import com.james.curly.data.response.post_event.PostEventResponse
import com.james.curly.data.service.EventService
import com.james.curly.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventService: EventService
):EventRepository {
    override suspend fun postUserBehavior(eventRequest: EventRequest): PostEventResponse {
        return eventService.postUserBehavior(eventRequest)
    }
}