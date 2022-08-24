package com.james.curly.data.request.post_events

import com.google.gson.annotations.SerializedName

data class EventRequest(
    @SerializedName("Event")
    val event: Event,
    @SerializedName("EventType")
    val eventType: String,
    @SerializedName("SessionId")
    val sessionId: String,
    @SerializedName("UserId")
    val userId: String
)