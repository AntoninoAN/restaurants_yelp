package com.example.restaurantsyelpcompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "alias")
    val alias: String? = null,
    @Json(name = "title")
    val title: String? = null
)