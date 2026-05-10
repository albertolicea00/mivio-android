package com.albertolicea00.mivio.domain.scanner

object GuessItParser {
    
    data class ParsedInfo(
        val title: String,
        val year: String?,
        val season: Int?,
        val episode: Int?,
        val resolution: String?
    )

    fun parse(filename: String): ParsedInfo {
        // Strip out the extension
        var name = filename.substringBeforeLast(".")
        
        // Remove common separators and replace with spaces
        name = name.replace(Regex("[._]"), " ")

        // Extract Title and Year. Typically year is 4 digits bounded by spaces or parenthesis
        val yearRegex = Regex("\\b(19\\d{2}|20\\d{2})\\b")
        val yearMatch = yearRegex.find(name)
        val year = yearMatch?.value

        // TV Show detection (S01E01 or 1x01)
        val pvrRegex = Regex("\\bS(\\d{1,2})E(\\d{1,2})\\b", RegexOption.IGNORE_CASE)
        val pvrMatch = pvrRegex.find(name)
        val season = pvrMatch?.groupValues?.get(1)?.toIntOrNull()
        val episode = pvrMatch?.groupValues?.get(2)?.toIntOrNull()

        // Determine title
        var titleEndIndex = name.length
        if (yearMatch != null) titleEndIndex = minOf(titleEndIndex, yearMatch.range.first)
        if (pvrMatch != null) titleEndIndex = minOf(titleEndIndex, pvrMatch.range.first)

        val title = name.substring(0, titleEndIndex).trim()

        // Resolution detection (1080p, 720p, 4k)
        val resRegex = Regex("\\b(720p|1080p|2160p|4k)\\b", RegexOption.IGNORE_CASE)
        val resMatch = resRegex.find(name)
        val resolution = resMatch?.value

        return ParsedInfo(
            title = title,
            year = year,
            season = season,
            episode = episode,
            resolution = resolution
        )
    }
}
