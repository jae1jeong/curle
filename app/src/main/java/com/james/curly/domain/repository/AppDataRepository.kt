package com.james.curly.domain.repository

interface AppDataRepository {
    fun getUserId():String?
    fun setUserId(userId:String)
}