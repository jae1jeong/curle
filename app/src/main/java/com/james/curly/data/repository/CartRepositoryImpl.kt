package com.james.curly.data.repository

import com.james.curly.data.dao.CartDao
import com.james.curly.data.entity.CartEntity
import com.james.curly.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
):CartRepository {
    override suspend fun addCard(cartEntity: CartEntity) {
        return cartDao.addCart(cartEntity)
    }

    override suspend fun updateCart(cartEntity: CartEntity) {
        return cartDao.updateCart(cartEntity)
    }

    override suspend fun deleteCart(cartEntity: CartEntity) {
        return cartDao.deleteCart(cartEntity)
    }

    override fun getCarts(): Flow<List<CartEntity>> {
        return cartDao.getCarts()
    }
}