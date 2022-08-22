package com.james.curly.di

import com.james.curly.data.dao.CartDao
import com.james.curly.data.repository.CartRepositoryImpl
import com.james.curly.domain.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCartRepository(cardDao: CartDao):CartRepository = CartRepositoryImpl(cardDao)
}