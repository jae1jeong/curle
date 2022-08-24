package com.james.curly.di

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import com.james.curly.data.repository.SharedPreferenceRepository
import com.james.curly.domain.repository.AppDataRepository
import com.james.curly.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDataRepository(@ApplicationContext context: Context):AppDataRepository = SharedPreferenceRepository(context)


}