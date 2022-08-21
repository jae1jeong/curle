package com.james.curly.di

import com.james.curly.presentation.cart.CartItemAdapter
import com.james.curly.presentation.cart.CartViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterModule {

    @Provides
    fun provideCardAdapter(cartViewModel: CartViewModel) = CartItemAdapter(cartViewModel)


}