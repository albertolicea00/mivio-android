package com.albertolicea00.mivio.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface OpenSubtitlesApi {
    @GET("subtitles")
    suspend fun searchSubtitles(
        @Header("Api-Key") apiKey: String,
        @Query("query") query: String,
        @Query("languages") languages: String = "en,es"
    ): OpenSubtitlesResponse
}

data class OpenSubtitlesResponse(
    val data: List<SubtitleData>
)

data class SubtitleData(
    val id: String,
    val attributes: SubtitleAttributes
)

data class SubtitleAttributes(
    val language: String,
    val url: String
)
