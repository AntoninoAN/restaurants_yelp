package com.example.restaurantsyelpcompose.rest

import com.example.restaurantsyelpcompose.utils.UIState
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val restaurant: StateFlow<UIState>
    fun getRestaurantList(location: String)
    fun getRestaurantDetails(uid:String)
}






