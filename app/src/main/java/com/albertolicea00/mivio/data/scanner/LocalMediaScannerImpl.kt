package com.albertolicea00.mivio.data.scanner

import com.albertolicea00.mivio.data.local.entity.MediaItemEntity
import com.albertolicea00.mivio.data.local.entity.SourceEntity
import com.albertolicea00.mivio.domain.repository.MediaRepository
import com.albertolicea00.mivio.domain.scanner.MediaScanner
import java.io.File
import javax.inject.Inject

class LocalMediaScannerImpl @Inject constructor(
    private val mediaRepository: MediaRepository
) : MediaScanner {

    private val supportedExtensions = listOf("mkv", "mp4", "avi", "mov", "webm")

    override suspend fun scanSource(source: SourceEntity) {
        if (source.type != "LOCAL") return
        
        val rootPath = source.path
        val directory = File(rootPath)
        
        if (!directory.exists() || !directory.isDirectory) return

        val foundMedia = mutableListOf<MediaItemEntity>()

        directory.walkTopDown().filter { file ->
            file.isFile && supportedExtensions.contains(file.extension.lowercase())
        }.forEach { file ->
            val mediaItem = MediaItemEntity(
                id = file.absolutePath.hashCode().toString(),
                path = file.absolutePath,
                type = if (file.absolutePath.contains("Season", ignoreCase = true) || file.name.contains("S\\d{2}E\\d{2}".toRegex())) "EPISODE" else "MOVIE",
                sourceId = source.id,
                fileName = file.name,
                size = file.length(),
                lastModified = file.lastModified()
            )
            foundMedia.add(mediaItem)
        }

        if (foundMedia.isNotEmpty()) {
            mediaRepository.insertMediaItems(foundMedia)
        }
    }
}
