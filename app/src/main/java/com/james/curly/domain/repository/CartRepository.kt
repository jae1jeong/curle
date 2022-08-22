package com.james.curly.domain.repository

import com.james.curly.data.entity.CartEntity
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun addCard(cartEntity: CartEntity)

    suspend fun updateCart(cartEntity: CartEntity)

    suspend fun deleteCart(cartEntity: CartEntity)

    fun getCarts():Flow<List<CartEntity>>
}