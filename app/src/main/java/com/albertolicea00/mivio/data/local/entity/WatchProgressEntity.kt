package com.albertolicea00.mivio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_progress")
data class WatchProgressEntity(
    @PrimaryKey val mediaItemId: String,
    val positionMs: Long,
    val durationMs: Long,
    val isWatched: Boolean
)
