package com.example.a1.models

import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getJoke(): JokeResponse
}