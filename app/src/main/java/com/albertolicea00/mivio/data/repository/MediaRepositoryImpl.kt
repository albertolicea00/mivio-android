package com.albertolicea00.mivio.data.repository

import com.albertolicea00.mivio.data.local.dao.MediaItemDao
import com.albertolicea00.mivio.data.local.dao.SourceDao
import com.albertolicea00.mivio.data.local.entity.MediaItemEntity
import com.albertolicea00.mivio.data.local.entity.SourceEntity
import com.albertolicea00.mivio.domain.repository.MediaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val mediaItemDao: MediaItemDao,
    private val sourceDao: SourceDao
) : MediaRepository {
    override fun getAllMediaItems(): Flow<List<MediaItemEntity>> = mediaItemDao.getAllMediaItems()
    override suspend fun insertMediaItems(items: List<MediaItemEntity>) = mediaItemDao.insertMediaItems(items)
    override fun getAllSources(): Flow<List<SourceEntity>> = sourceDao.getAllSources()
    override suspend fun addSource(source: SourceEntity) = sourceDao.insertSource(source)
}
