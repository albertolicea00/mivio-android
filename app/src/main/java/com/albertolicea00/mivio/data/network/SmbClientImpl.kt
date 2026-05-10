package com.albertolicea00.mivio.data.network

import com.albertolicea00.mivio.data.local.entity.SourceEntity
import com.albertolicea00.mivio.domain.network.NetworkClient
import com.albertolicea00.mivio.domain.network.NetworkFile
import jcifs.context.SingletonContext
import jcifs.smb.NtlmPasswordAuthenticator
import jcifs.smb.SmbFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import javax.inject.Inject

class SmbClientImpl @Inject constructor() : NetworkClient {

    private fun getContext(source: SourceEntity): jcifs.context.CIFSContext {
        val baseContext = SingletonContext.getInstance()
        if (!source.username.isNullOrEmpty() && source.password != null) {
            val auth = NtlmPasswordAuthenticator("", source.username, source.password)
            return baseContext.withCredentials(auth)
        }
        return baseContext.withAnonymousCredentials()
    }

    override suspend fun listFiles(source: SourceEntity): List<NetworkFile> = withContext(Dispatchers.IO) {
        if (source.type != "SMB") return@withContext emptyList()
        val context = getContext(source)
        val smbFile = SmbFile(source.path, context)
        
        if (!smbFile.exists() || !smbFile.isDirectory) return@withContext emptyList()

        smbFile.listFiles()?.map {
            NetworkFile(
                path = it.url.toString(),
                name = it.name,
                size = try { it.length() } catch(e: Exception) { 0 },
                isDirectory = it.isDirectory
            )
        } ?: emptyList()
    }

    override suspend fun getFileInputStream(source: SourceEntity, filePath: String): InputStream = withContext(Dispatchers.IO) {
        val context = getContext(source)
        val smbFile = SmbFile(filePath, context)
        smbFile.inputStream
    }
}
