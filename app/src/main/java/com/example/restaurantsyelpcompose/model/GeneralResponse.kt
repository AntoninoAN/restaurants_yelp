package com.example.restaurantsyelpcompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeneralResponse(
    @Json(name = "businesses")
    val businesses: List<BusinessDetail?>? = null,
    @Json(name = "region")
    val region: Region? = null,
    @Json(name = "total")
    val total: Int? = null
)