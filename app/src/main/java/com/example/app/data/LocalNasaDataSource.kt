package com.example.app.data

import com.example.app.data.dto.Apod
import javax.inject.Inject

// todo - use Room database
class LocalNasaDataSource @Inject constructor() {

    private var apod: Apod? = null

    suspend fun get(): Apod? {
        return apod
    }

    suspend fun update(apod: Apod) {
        this.apod = apod
    }
}
