package com.example.app.data

import com.example.app.data.dto.Apod
import retrofit2.http.GET

private const val API_KEY = "L5Vc980g0ZRu1rUfsfLWGy7QTimZm0xxqYoGBFOB"

interface NasaService {

    @GET("planetary/apod?api_key=$API_KEY")
    suspend fun get(): Apod
}
