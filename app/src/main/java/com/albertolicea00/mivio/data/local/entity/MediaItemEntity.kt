package com.albertolicea00.mivio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media_item")
data class MediaItemEntity(
    @PrimaryKey val id: String,
    val path: String,
    val type: String, // "MOVIE" or "EPISODE"
    val sourceId: String,
    val fileName: String,
    val size: Long,
    val lastModified: Long
)
