package com.useranonimo.myapplication.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class ShortenRequest (
    val url: String
)

interface UrlShortenerService {
    @POST("api/alias")
    suspend fun shortenUrl(
        @Body request: ShortenRequest
    ): UrlResponse

    @GET("api/alias/{id}")
    suspend fun getOriginalUrl(
        @Path("id") alias: String
    ): OriginalUrlResponse
}