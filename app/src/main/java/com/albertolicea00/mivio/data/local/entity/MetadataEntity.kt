package com.albertolicea00.mivio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "metadata")
data class MetadataEntity(
    @PrimaryKey val mediaItemId: String,
    val tmdbId: Int?,
    val title: String,
    val year: Int?,
    val posterUrl: String?,
    val backdropUrl: String?,
    val synopsis: String?,
    val rating: Double?,
    val cast: String?
)
