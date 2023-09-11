package com.example.shacklehotelbuddy.ui.detail

import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.base.BaseViewModel
import com.example.shacklehotelbuddy.base.BaseViewModel.ViewEvent
import com.example.shacklehotelbuddy.data.SearchHotelsResourceProvider
import com.example.shacklehotelbuddy.domain.GetHotelsUseCase
import com.example.shacklehotelbuddy.domain.ShackleResult
import com.example.shacklehotelbuddy.model.AgeData
import com.example.shacklehotelbuddy.model.CheckInOutData
import com.example.shacklehotelbuddy.model.DestinationData
import com.example.shacklehotelbuddy.model.Hotels
import com.example.shacklehotelbuddy.model.RoomsData
import com.example.shacklehotelbuddy.model.SearchHotels
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchHotelsViewModel(
    private val getHotelsUseCase: GetHotelsUseCase,
    private val homeResourceProvider: SearchHotelsResourceProvider
) : BaseViewModel<HomeViewEvent>() {

    private val _homeState = MutableStateFlow(SearchHotelsUiState())
    val homeState = _homeState.asStateFlow()

    private var searchHotelRequest = SearchHotels()

    init {
        createRequest()
    }

    private fun createRequest() {
        val destinationData = DestinationData(
            regionId = "6054439"
        )
        val checkInDate = CheckInOutData(
            day = 10,
            month = 10,
            year = 2023
        )
        val checkOutDate = CheckInOutData(
            day = 15,
            month = 10,
            year = 2023
        )
        val rooms = listOf<RoomsData>(
            RoomsData(
                adults = 2,
                childrenAges = listOf<AgeData>(
                    AgeData(
                        age = 3
                    ),
                    AgeData(
                        age = 4
                    ),
                    AgeData(
                        age = 2
                    )
                )
            )
        )

        searchHotelRequest = SearchHotels(
            destination = destinationData,
            checkInDate = checkInDate,
            checkOutDate = checkOutDate,
            rooms = rooms,
            resultsStartingIndex = 0,
            resultsSize = 20,
        )
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val response = getHotelsUseCase(searchHotelRequest)
            if (response is ShackleResult.Success) {
                _homeState.update { homeUiState ->
                    homeUiState.copy(
                        hotels = response.data
                    )
                }
            } else {
                _homeState.update { homeUiState ->
                    homeUiState.copy(isLoading = false)
                }
            }
        }
    }
}

data class SearchHotelsUiState(
    val hasError: Boolean = false,
    val isLoading: Boolean = false,
    val hotels: List<Hotels> = emptyList()
) {
    val hasData: Boolean = hotels.isNotEmpty()
}

sealed class HomeViewEvent : ViewEvent() {
    object ClearSearchQuery : HomeViewEvent()
}
