package com.example.prueba.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.data.ApiClient
import com.example.prueba.data.Episode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> get() = _episodes

    init {
        fetchEpisodes()
    }

    private fun fetchEpisodes() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getEpisodes()
                _episodes.value = response.results
            } catch (e: Exception) {
                _episodes.value = emptyList() // Manejo de errores
            }
        }
    }
}
