package com.example.shacklehotelbuddy.data

import com.example.shacklehotelbuddy.domain.Failure
import com.example.shacklehotelbuddy.domain.HotelFailure.NoHotelFailure
import com.example.shacklehotelbuddy.domain.ShackleResult
import com.example.shacklehotelbuddy.domain.ShackleResult.Error
import com.example.shacklehotelbuddy.domain.ShackleResult.Success
import com.example.shacklehotelbuddy.domain.flatMap
import com.example.shacklehotelbuddy.domain.invokeApiCall
import com.example.shacklehotelbuddy.model.Hotels
import com.example.shacklehotelbuddy.model.SearchHotels


class RemoteSearchHotelDataSource(
    private val shackleService: ShackleService,
    private val hotelsMapper: HotelsMapper,
) : SearchHotelDataSource {

    override suspend fun getSearchedHotels(param: SearchHotels): ShackleResult<Failure, List<Hotels>> {
        return invokeApiCall {
            shackleService.getSearchedHotels(request = param)
        }.flatMap { data ->
            val remoteProperties = data.data?.propertySearch?.properties
            if (remoteProperties?.isEmpty() == true) {
                Error(NoHotelFailure)
            } else {
                val photos = hotelsMapper.map(remoteProperties)

                Success(photos)
            }
        }
    }
}