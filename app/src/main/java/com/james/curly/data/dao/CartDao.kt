package com.james.curly.data.dao

import androidx.room.*
import com.james.curly.data.entity.CartEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCart(cartEntity: CartEntity)

    @Update
    suspend fun updateCart(cartEntity: CartEntity)

    @Delete
    suspend fun deleteCart(cartEntity: CartEntity)

    @Query("SELECT * FROM CartEntity")
    fun getCarts(): Flow<List<CartEntity>>
}