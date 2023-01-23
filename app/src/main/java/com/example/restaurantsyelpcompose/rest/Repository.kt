package com.example.restaurantsyelpcompose.rest

import com.example.restaurantsyelpcompose.utils.UIState
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val restaurant: StateFlow<UIState>
    fun getRestaurantList()
    fun getRestaurantDetails(uid:String)
}




