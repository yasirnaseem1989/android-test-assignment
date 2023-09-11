package com.example.shacklehotelbuddy.data

import com.example.shacklehotelbuddy.model.RemoteHotelsResponse
import com.example.shacklehotelbuddy.model.SearchHotels
import com.example.shacklehotelbuddy.utils.AppConstants
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ShackleService {

    @POST("properties/v2/list")
    suspend fun getSearchedHotels(
        @Header("X-RapidAPI-Key") key: String = AppConstants.API_KEY,
        @Header("X-RapidAPI-Host") host: String = AppConstants.API_HOST,
        @Body request: SearchHotels,
    ): RemoteHotelsResponse
}