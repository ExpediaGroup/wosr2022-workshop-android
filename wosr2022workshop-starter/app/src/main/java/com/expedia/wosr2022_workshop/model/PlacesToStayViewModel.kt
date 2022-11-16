package com.expedia.wosr2022_workshop.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expedia.wosr2022_workshop.repositories.PlacesLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlacesToStayViewModel(private val repository: PlacesLocalRepository) : ViewModel() {

    val isLoading = mutableStateOf(true)

    private val loadingPlaces: ArrayList<Property> =
        com.expedia.wosr2022_workshop.application.mockPlaces

    var recentlyViewed: MutableState<List<Property>> = mutableStateOf(loadingPlaces)
    var recommendedStays: MutableState<List<Property>> = mutableStateOf(loadingPlaces)

    init {
        getPlacesToStay()
    }

    private fun getPlacesToStay() {
        isLoading.value = true
        viewModelScope.launch {
            loadPlaces()
        }
    }

    private suspend fun loadPlaces() = withContext(Dispatchers.IO) {
        repository.loadPlaces()
            .collect {
                delay(300)
                recentlyViewed.value = it.places.recentlyViewed
                recommendedStays.value = it.places.recommendedStays
                isLoading.value = false
            }
    }
}