package com.james.curly.data.repository

import android.content.Context
import com.james.curly.domain.repository.AppDataRepository
import com.james.curly.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferenceRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : AppDataRepository {

    companion object{
        const val CURLY_PREF_NAME = "curly_pref"
    }

    private val pref = context.getSharedPreferences(CURLY_PREF_NAME,Context.MODE_PRIVATE)

    override fun getUserId(): String? {
        return pref.getString(Constants.USER_ID,null)
    }

    override fun setUserId(userId: String) {
        pref.edit()
            .putString(Constants.USER_ID,userId)
            .apply()
    }
}