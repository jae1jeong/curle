package com.james.curly.di

import android.content.Context
import androidx.room.Room
import com.james.curly.data.db.CartDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideCartDatabase(
        @ApplicationContext context: Context
    ):CartDatabase = Room.databaseBuilder(context,CartDatabase::class.java,"cart_db").build()

    @Singleton
    @Provides
    fun provideCartDao(
        cartDatabase: CartDatabase
    ) = cartDatabase.cartDao()
}
