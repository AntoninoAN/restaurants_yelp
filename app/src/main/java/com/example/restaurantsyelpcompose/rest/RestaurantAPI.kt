package com.example.restaurantsyelpcompose.rest

import com.example.restaurantsyelpcompose.model.RestaurantResponse
import com.example.restaurantsyelpcompose.utils.ENDPOINT
import com.example.restaurantsyelpcompose.utils.PARAM_UID

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface RestaurantAPI {
    @GET(ENDPOINT)
    suspend fun getRestaurantDetails(
        @Path(PARAM_UID) uid: String
    ) : Response<RestaurantResponse>

}