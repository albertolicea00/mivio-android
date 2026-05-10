package com.albertolicea00.mivio.data.local.dao

import androidx.room.*
import com.albertolicea00.mivio.data.local.entity.MetadataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MetadataDao {
    @Query("SELECT * FROM metadata WHERE mediaItemId = :id")
    fun getMetadata(id: String): Flow<MetadataEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetadata(metadata: MetadataEntity)
}
