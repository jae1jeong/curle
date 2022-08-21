package com.james.curly.data.repository

import com.james.curly.domain.repository.AppLocalDataRepository

class DataStoreRepositoryImpl :AppLocalDataRepository{
    private var jwtToken:String = ""

    override fun getJwtToken(): String {
        // TODO: dataStore로 값 넘겨주기
        return jwtToken
    }

    override fun setJwtToken(token: String) {
//        CoroutineScope.launch() {
//            // jwtToken
//        }
    }
}