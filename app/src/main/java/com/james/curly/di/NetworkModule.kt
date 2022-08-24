package com.james.curly.di

import com.james.curly.BuildConfig
import com.james.curly.data.service.EventService
import com.james.curly.data.service.RecommendService
import com.james.curly.data.service.SearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    @Named("basic")
    fun provideRetrofit(
    ): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain: Interceptor.Chain ->
                val builder = chain.request().newBuilder()
                builder.addHeader("x-api-key", BuildConfig.API_KEY)
                chain.proceed(builder.build())
            }.build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @Named("cloudSearch")
    fun provideCloudSearchRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.SEARCH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRecommendService(@Named("basic")retrofit: Retrofit): RecommendService = retrofit.create(RecommendService::class.java)

    @Singleton
    @Provides
    fun provideEventService(@Named("basic")retrofit: Retrofit): EventService = retrofit.create(EventService::class.java)

    @Singleton
    @Provides
    fun provideSearchService(@Named("cloudSearch")retrofit: Retrofit):SearchService = retrofit.create(SearchService::class.java)

}