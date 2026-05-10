package com.albertolicea00.mivio.data.local.dao

import androidx.room.*
import com.albertolicea00.mivio.data.local.entity.MediaItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MediaItemDao {
    @Query("SELECT * FROM media_item")
    fun getAllMediaItems(): Flow<List<MediaItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMediaItems(items: List<MediaItemEntity>)

    @Query("DELETE FROM media_item")
    suspend fun deleteAll()
}
