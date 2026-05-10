package com.albertolicea00.mivio.domain.network

import com.albertolicea00.mivio.data.local.entity.SourceEntity
import java.io.InputStream

interface NetworkClient {
    suspend fun listFiles(source: SourceEntity): List<NetworkFile>
    suspend fun getFileInputStream(source: SourceEntity, filePath: String): InputStream
}

data class NetworkFile(
    val path: String,
    val name: String,
    val size: Long,
    val isDirectory: Boolean
)
