package com.albertolicea00.mivio.data.local.dao

import androidx.room.*
import com.albertolicea00.mivio.data.local.entity.SourceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SourceDao {
    @Query("SELECT * FROM source")
    fun getAllSources(): Flow<List<SourceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSource(source: SourceEntity)

    @Delete
    suspend fun deleteSource(source: SourceEntity)
}
