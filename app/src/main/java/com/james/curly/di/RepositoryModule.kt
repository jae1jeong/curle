package com.james.curly.di

import com.james.curly.data.service.RecommendService
import com.james.curly.data.dao.CartDao
import com.james.curly.data.repository.CartRepositoryImpl
import com.james.curly.data.repository.EventRepositoryImpl
import com.james.curly.data.repository.RecommendRepositoryImpl
import com.james.curly.data.repository.SearchRepositoryImpl
import com.james.curly.data.service.EventService
import com.james.curly.data.service.SearchService
import com.james.curly.domain.repository.CartRepository
import com.james.curly.domain.repository.EventRepository
import com.james.curly.domain.repository.RecommendRepository
import com.james.curly.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCartRepository(cardDao: CartDao):CartRepository = CartRepositoryImpl(cardDao)



    @Singleton
    @Provides
    fun provideRecommendRepository(recommendService: RecommendService) :RecommendRepository = RecommendRepositoryImpl(recommendService)


    @Singleton
    @Provides
    fun provideEventRepository(eventService: EventService) :EventRepository= EventRepositoryImpl(eventService)

    @Singleton
    @Provides
    fun provideSearchRepository(searchService: SearchService):SearchRepository = SearchRepositoryImpl(searchService)
}