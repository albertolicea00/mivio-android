package com.albertolicea00.mivio.domain.scanner

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GuessItParserTest {

    @Test
    fun testParseSimpleMovieWithoutYear() {
        val result = GuessItParser.parse("Interstellar.mp4")
        assertEquals("Interstellar", result.title)
        assertNull(result.year)
        assertNull(result.season)
        assertNull(result.episode)
        assertNull(result.resolution)
    }

    @Test
    fun testParseMovieWithYearAndResolution() {
        val result = GuessItParser.parse("Interstellar.2014.1080p.BluRay.mp4")
        assertEquals("Interstellar", result.title)
        assertEquals("2014", result.year)
        assertNull(result.season)
        assertNull(result.episode)
        assertEquals("1080p", result.resolution)
    }

    @Test
    fun testParseMovieWithUnderscoresAnd4K() {
        val result = GuessItParser.parse("The_Matrix_1999_2160P_UHD.mkv")
        assertEquals("The Matrix", result.title)
        assertEquals("1999", result.year)
        assertNull(result.season)
        assertNull(result.episode)
        assertEquals("2160P", result.resolution)
    }

    @Test
    fun testParseTVEpisodeStandardS01E01() {
        val result = GuessItParser.parse("Breaking.Bad.S01E02.720p.mkv")
        assertEquals("Breaking Bad", result.title)
        assertNull(result.year)
        assertEquals(1, result.season)
        assertEquals(2, result.episode)
        assertEquals("720p", result.resolution)
    }

    @Test
    fun testParseTVEpisodeCaseInsensitive() {
        val result = GuessItParser.parse("Breaking.Bad.s05e16.1080p.mkv")
        assertEquals("Breaking Bad", result.title)
        assertNull(result.year)
        assertEquals(5, result.season)
        assertEquals(16, result.episode)
        assertEquals("1080p", result.resolution)
    }

    @Test
    fun testParseTVEpisodeWithYearInTitle() {
        val result = GuessItParser.parse("Show.Name.2020.S01E01.1080p.mkv")
        assertEquals("Show Name", result.title)
        assertEquals("2020", result.year)
        assertEquals(1, result.season)
        assertEquals(1, result.episode)
        assertEquals("1080p", result.resolution)
    }
}
