package com.albertolicea00.mivio.di

import android.app.Application
import androidx.room.Room
import com.albertolicea00.mivio.data.local.MivioDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMivioDatabase(app: Application): MivioDatabase {
        return Room.databaseBuilder(
            app,
            MivioDatabase::class.java,
            "mivio_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMediaItemDao(db: MivioDatabase) = db.mediaItemDao

    @Provides
    @Singleton
    fun provideMetadataDao(db: MivioDatabase) = db.metadataDao

    @Provides
    @Singleton
    fun provideWatchProgressDao(db: MivioDatabase) = db.watchProgressDao

    @Provides
    @Singleton
    fun provideSourceDao(db: MivioDatabase) = db.sourceDao
}
