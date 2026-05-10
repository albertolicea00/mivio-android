package com.albertolicea00.mivio.domain.repository

import com.albertolicea00.mivio.data.local.entity.MediaItemEntity
import com.albertolicea00.mivio.data.local.entity.SourceEntity
import kotlinx.coroutines.flow.Flow

interface MediaRepository {
    fun getAllMediaItems(): Flow<List<MediaItemEntity>>
    suspend fun insertMediaItems(items: List<MediaItemEntity>)
    fun getAllSources(): Flow<List<SourceEntity>>
    suspend fun addSource(source: SourceEntity)
}
