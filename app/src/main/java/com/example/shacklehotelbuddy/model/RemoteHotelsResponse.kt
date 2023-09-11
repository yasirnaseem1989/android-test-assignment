package com.example.shacklehotelbuddy.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class RemoteHotelsResponse(
    @field:Json(name = "data") val data: PropertyData? = null,
)

@Keep
@JsonClass(generateAdapter = true)
data class PropertyData(
    @field:Json(name = "propertySearch") val propertySearch: PropertySearch? = null,
)


@Keep
@JsonClass(generateAdapter = true)
data class PropertySearch(
    @field:Json(name = "properties") val properties: List<Properties>? = null
)

@Keep
@JsonClass(generateAdapter = true)
data class Properties(
    @field:Json(name = "name") val title: String? = null,
    val subtitle: String? = null,
    val description: String? = null,
    val rating: Double? = null,
    val largeImageURL: String? = null,
)


