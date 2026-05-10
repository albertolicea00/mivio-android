package com.albertolicea00.mivio.data.network

import com.albertolicea00.mivio.data.local.entity.SourceEntity
import com.albertolicea00.mivio.domain.network.NetworkClient
import com.albertolicea00.mivio.domain.network.NetworkFile
import com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import javax.inject.Inject

class WebDavClientImpl @Inject constructor() : NetworkClient {

    private fun getSardine(source: SourceEntity): OkHttpSardine {
        val sardine = OkHttpSardine()
        if (!source.username.isNullOrEmpty() && source.password != null) {
            sardine.setCredentials(source.username, source.password)
        }
        return sardine
    }

    override suspend fun listFiles(source: SourceEntity): List<NetworkFile> = withContext(Dispatchers.IO) {
        if (source.type != "WEBDAV") return@withContext emptyList()
        val sardine = getSardine(source)
        
        try {
            val resources = sardine.list(source.path)
            resources.drop(1).map {
                NetworkFile(
                    path = it.href.toString(),
                    name = it.name,
                    size = it.contentLength ?: 0L,
                    isDirectory = it.isDirectory
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getFileInputStream(source: SourceEntity, filePath: String): InputStream = withContext(Dispatchers.IO) {
        val sardine = getSardine(source)
        sardine.get(filePath)
    }
}
