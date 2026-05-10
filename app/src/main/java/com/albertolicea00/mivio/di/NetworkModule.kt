package com.albertolicea00.mivio.di

import com.albertolicea00.mivio.data.remote.api.OpenSubtitlesApi
import com.albertolicea00.mivio.data.remote.api.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideTmdbApi(): TmdbApi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOpenSubtitlesApi(): OpenSubtitlesApi {
        return Retrofit.Builder()
            .baseUrl("https://api.opensubtitles.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenSubtitlesApi::class.java)
    }
}
