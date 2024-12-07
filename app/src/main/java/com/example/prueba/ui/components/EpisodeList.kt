package com.example.prueba.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prueba.viewmodel.EpisodeViewModel

@Composable
fun EpisodeList(
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = viewModel()
) {
    val episodes = viewModel.episodes.collectAsState()

    LazyColumn(modifier = modifier) {
        items(episodes.value) { episode ->
            val imageUrl = "https://wallpapers.com/images/featured-full/imagenes-de-rick-and-morty-b3e2pq02sb2fuvy3.jpg"
            EpisodeCard(episode = episode, imageUrl = imageUrl)
        }
    }
}
