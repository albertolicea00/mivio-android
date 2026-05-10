package com.albertolicea00.mivio.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("year") year: String? = null
    ): TmdbSearchResponse

    @GET("search/tv")
    suspend fun searchTv(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("first_air_date_year") year: String? = null
    ): TmdbSearchResponse
}

data class TmdbSearchResponse(
    val page: Int,
    val results: List<TmdbMovieResult>
)

data class TmdbMovieResult(
    val id: Int,
    val title: String?,
    val name: String?,
    val release_date: String?,
    val first_air_date: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    val overview: String?,
    val vote_average: Double?
)
