package com.example.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import coil3.compose.AsyncImage

@Composable
fun MainScreen(viewModel: MainViewModel) {
    MainScreen(viewModel.url)
}

@Composable
private fun MainScreen(url: String?) {
    AsyncImage(
        model = url,
        contentDescription = null,
    )
}

@PreviewLightDark
@Composable
private fun Preview() {
    MainScreen(
        url = "https://apod.nasa.gov/apod/image/2501/AuroraSar_Masi_1280.jpg",
    )
}