package com.albertolicea00.mivio.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albertolicea00.mivio.data.local.dao.*
import com.albertolicea00.mivio.data.local.entity.*

@Database(
    entities = [
        MediaItemEntity::class,
        MetadataEntity::class,
        WatchProgressEntity::class,
        SourceEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MivioDatabase : RoomDatabase() {
    abstract val mediaItemDao: MediaItemDao
    abstract val metadataDao: MetadataDao
    abstract val watchProgressDao: WatchProgressDao
    abstract val sourceDao: SourceDao
}
