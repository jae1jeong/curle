package com.james.curly.presentation.recommend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.james.curly.BuildConfig
import com.james.curly.data.request.post_recommend.RecommendRequest
import com.james.curly.data.response.post_recommend.Item
import com.james.curly.domain.repository.RecommendRepository
import com.james.curly.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(
    private val recommendRepository: RecommendRepository,
) : BaseViewModel() {

    private val _firstRecommendItems = MutableLiveData<List<Item>>()
    val firstRecommendItems: LiveData<List<Item>> get() = _firstRecommendItems
    private val _secondRecommendItems = MutableLiveData<List<Item>>()
    val secondRecommendItems: LiveData<List<Item>> get() = _secondRecommendItems

    fun getRecommendItems(userId: String, typeRecommend: String) {
        viewModelScope.launch {
            try {
                var age: Int? = null
                var gender: String? = null

                val filterArn = when (typeRecommend) {
                    "personalize" -> {
                        BuildConfig.PERSONALIZE
                    }
                    else -> {
                        if (userId.isNotEmpty()) {
                            val (_, a, g) = userId.split(",")
                            age = a.toInt()
                            gender = g
                        }
                        BuildConfig.BEAUTY
                    }
                }
                val response = recommendRepository.postRecommend(
                    RecommendRequest(
                        userId,
                        filterArn,
                        typeRecommend,
                        age,
                        gender,
                    )
                )
                if (typeRecommend == "personalize") {
                    _firstRecommendItems.value = response.itemList
                } else {
                    _secondRecommendItems.value = response.itemList
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}