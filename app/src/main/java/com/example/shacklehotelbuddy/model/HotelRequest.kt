package com.example.shacklehotelbuddy.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchHotels(
    @field:Json(name = "destination") val destination: DestinationData? = null,
    @field:Json(name = "checkInDate") val checkInDate: CheckInOutData? = null,
    @field:Json(name = "checkOutDate") val checkOutDate: CheckInOutData? = null,
    @field:Json(name = "rooms") val rooms: List<RoomsData>? = null,
    @field:Json(name = "resultsStartingIndex") val resultsStartingIndex: Int? = null,
    @field:Json(name = "resultsSize") val resultsSize: Int? = null,
)

@JsonClass(generateAdapter = true)
data class DestinationData(
    @field:Json(name = "regionId") val regionId: String? = null,
)

@JsonClass(generateAdapter = true)
data class CheckInOutData(
    @field:Json(name = "day") val day: Int? = null,
    @field:Json(name = "month") val month: Int? = null,
    @field:Json(name = "year") val year: Int? = null,
)

@JsonClass(generateAdapter = true)
data class RoomsData(
    @field:Json(name = "adults") val adults: Int? = null,
    @field:Json(name = "children") val childrenAges: List<AgeData>? = null,
)

@JsonClass(generateAdapter = true)
data class AgeData(
    @field:Json(name = "age") val age: Int? = null,
)
