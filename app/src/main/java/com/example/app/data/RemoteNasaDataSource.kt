package com.example.app.data

import com.example.app.data.dto.Apod
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private const val BASE_URL = "https://api.nasa.gov/"

class RemoteNasaDataSource @Inject constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(NasaService::class.java)

    suspend fun get(): Apod {
        return service.get()
    }
}
