package com.james.curly.domain.repository

interface AppLocalDataRepository {


    fun getJwtToken():String
    fun setJwtToken(token:String)

}