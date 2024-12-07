package com.example.prueba.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("episode")
    suspend fun getEpisodes(
        @Query("page") page: Int = 1
    ): EpisodeResponse
}
