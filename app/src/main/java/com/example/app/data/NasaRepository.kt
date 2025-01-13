package com.example.app.data

import android.util.Log
import com.example.app.data.dto.Apod
import javax.inject.Inject

/**
 * The one-stop-shop for the rest of the app to get data
 */
class NasaRepository @Inject constructor(
    private val localNasaDataSource: LocalNasaDataSource,
    private val remoteNasaDataSource: RemoteNasaDataSource,
) {
    /**
     * First fetches fresh data from remote, then updates the local data source and returns
     */
    suspend fun get(): Apod? {
        try {
            val apod = remoteNasaDataSource.get()
            localNasaDataSource.update(apod)
        } catch (e: Exception) {
            Log.d(this::class.simpleName, "Connection failed")
        }

        return localNasaDataSource.get()
    }
}
