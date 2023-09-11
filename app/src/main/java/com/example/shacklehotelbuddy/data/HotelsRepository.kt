package com.example.shacklehotelbuddy.data

import com.example.shacklehotelbuddy.domain.Failure
import com.example.shacklehotelbuddy.domain.ShackleResult
import com.example.shacklehotelbuddy.model.Hotels
import com.example.shacklehotelbuddy.model.SearchHotels

class HotelsRepository(
    private val remoteHomeDataSource: SearchHotelDataSource,
) {
    suspend fun getSearchedHotels(param: SearchHotels): ShackleResult<Failure, List<Hotels>> =
        remoteHomeDataSource.getSearchedHotels(param)

}

