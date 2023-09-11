package com.example.shacklehotelbuddy.domain


import com.example.shacklehotelbuddy.data.HotelsRepository
import com.example.shacklehotelbuddy.domain.Failure.FeatureFailure
import com.example.shacklehotelbuddy.domain.HotelFailure.NoHotelFailure
import com.example.shacklehotelbuddy.domain.ShackleResult.Error
import com.example.shacklehotelbuddy.model.Hotels
import com.example.shacklehotelbuddy.model.SearchHotels
import kotlinx.coroutines.CoroutineDispatcher

class GetHotelsUseCase(
    private val homeRepository: HotelsRepository,
    ioDispatcher: CoroutineDispatcher
) : BaseUseCase<SearchHotels, List<Hotels>>(ioDispatcher) {

    override suspend fun execute(params: SearchHotels): ShackleResult<Failure, List<Hotels>> {
        val regionId = params.destination?.regionId.isNullOrBlank()
        if (regionId) {
            Error(NoHotelFailure)
        }

        return homeRepository.getSearchedHotels(params)
    }
 }

sealed class HotelFailure : FeatureFailure() {
    object NoHotelFailure : HotelFailure()
}