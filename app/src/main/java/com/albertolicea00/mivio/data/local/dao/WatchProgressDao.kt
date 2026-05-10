package com.albertolicea00.mivio.data.local.dao

import androidx.room.*
import com.albertolicea00.mivio.data.local.entity.WatchProgressEntity

@Dao
interface WatchProgressDao {
    @Query("SELECT * FROM watch_progress WHERE mediaItemId = :id")
    suspend fun getProgress(id: String): WatchProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: WatchProgressEntity)
}
