package com.example.restaurantsyelpcompose.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusinessDetail(
    @Json(name = "alias")
    val alias: String? = null,
    @Json(name = "categories")
    val categories: List<Category?>? = null,
    @Json(name = "coordinates")
    val coordinates: Coordinates? = null,
    @Json(name = "display_phone")
    val displayPhone: String? = null,
    @Json(name = "distance")
    val distance: Double? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null,
    @Json(name = "is_closed")
    val isClosed: Boolean? = null,
    @Json(name = "location")
    val location: Location? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "price")
    val price: String? = null,
    @Json(name = "rating")
    val rating: Double? = null,
    @Json(name = "review_count")
    val reviewCount: Int? = null,
    @Json(name = "transactions")
    val transactions: List<String?>? = null,
    @Json(name = "url")
    val url: String? = null
)