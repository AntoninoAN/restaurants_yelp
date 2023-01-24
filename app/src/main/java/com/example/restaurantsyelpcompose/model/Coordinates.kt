package com.example.restaurantsyelpcompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    @Json(name = "latitude")
    val latitude: Double? = null,
    @Json(name = "longitude")
    val longitude: Double? = null
)