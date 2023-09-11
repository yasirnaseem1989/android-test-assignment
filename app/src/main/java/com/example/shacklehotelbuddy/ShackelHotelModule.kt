package com.example.shacklehotelbuddy

import com.example.shacklehotelbuddy.data.HotelsMapper
import com.example.shacklehotelbuddy.data.HotelsRepository
import com.example.shacklehotelbuddy.data.RemoteSearchHotelDataSource
import com.example.shacklehotelbuddy.data.SearchHotelDataSource
import com.example.shacklehotelbuddy.data.SearchHotelsResourceProvider
import com.example.shacklehotelbuddy.di.DISPATCHER_IO
import com.example.shacklehotelbuddy.domain.GetHotelsUseCase
import com.example.shacklehotelbuddy.ui.detail.SearchHotelsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val MAPPER_HOTELS_REMOTE = "MAPPER_PHOTOS_REMOTE"

private const val DATA_SOURCE_HOTEL_SEARCH_REMOTE = "DATA_SOURCE_HOTEL_SEARCH_REMOTE"

private const val REPOSITORY_HOTELS = "REPOSITORY_HOTELS"

val searchHotelsModule = module {

    factory {
        SearchHotelsResourceProvider(androidContext())
    }

    factory<SearchHotelDataSource>(named(DATA_SOURCE_HOTEL_SEARCH_REMOTE)) {
        RemoteSearchHotelDataSource(get(), get(named(MAPPER_HOTELS_REMOTE)))
    }

    factory(named(MAPPER_HOTELS_REMOTE)) {
        HotelsMapper()
    }

    factory(named(REPOSITORY_HOTELS)) {
        HotelsRepository(
            get(named(DATA_SOURCE_HOTEL_SEARCH_REMOTE)),
        )
    }

    factory {
        GetHotelsUseCase(
            get(named(REPOSITORY_HOTELS)),
            get(named(DISPATCHER_IO))
        )
    }

    viewModel {
        SearchHotelsViewModel(get(), get())
    }
}
