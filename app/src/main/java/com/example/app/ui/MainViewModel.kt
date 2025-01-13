package com.example.app.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val nasaRepository: NasaRepository,
) : ViewModel() {

    var url by mutableStateOf<String?>(null)
        private set

    init {
        viewModelScope.launch {
            try {
                url = nasaRepository.get()
                    ?.url
            } catch (e: Exception) {

            } finally {

            }
        }
    }
}
