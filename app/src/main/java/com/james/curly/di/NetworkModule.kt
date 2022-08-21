package com.james.curly.di

import com.james.curly.domain.repository.AppLocalDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(
        appLocalDataRepository: AppLocalDataRepository
    ): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain: Interceptor.Chain ->
                val builder = chain.request().newBuilder()
                val jwtToken = appLocalDataRepository.getJwtToken()
                if (jwtToken.isNotEmpty()) {
                    builder.addHeader("Authorization", "Bearer $jwtToken")
                }
                chain.proceed(builder.build())
            }.build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}