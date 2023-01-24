package com.example.restaurantsyelpcompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Region(
    @Json(name = "center")
    val center: Center? = null
)