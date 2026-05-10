package com.albertolicea00.mivio.domain.scanner

import com.albertolicea00.mivio.data.local.entity.SourceEntity

interface MediaScanner {
    suspend fun scanSource(source: SourceEntity)
}
