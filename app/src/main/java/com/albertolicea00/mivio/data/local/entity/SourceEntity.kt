package com.albertolicea00.mivio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "source")
data class SourceEntity(
    @PrimaryKey val id: String,
    val type: String,
    val path: String,
    val username: String?,
    val password: String?
)
