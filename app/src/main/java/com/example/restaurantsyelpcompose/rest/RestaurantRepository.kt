package com.example.restaurantsyelpcompose.rest

import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantRepository: Repository {
    private val _restaurant = MutableStateFlow<UIState>(UIState.Empty)
    override val restaurant: StateFlow<UIState>
        get() = _restaurant

    override fun getRestaurantList(latitude: Double, longitude: Double) {
        TODO("Not yet implemented")
    }

    override fun getRestaurantDetails(uid: String) {
        TODO("Not yet implemented")
    }
}