package com.example.restaurantsyelpcompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState
import com.example.restaurantsyelpcompose.rest.Repository
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: Repository): ViewModel() {

    /**this is our RestaurantViewModel
    //add varialbles
    //add livedata mutable live data
    //add livedata of ui state
    //methods getrestaurantlist & getrestaurantdetials
    // that receives UID string
    */

    private val _data = MutableLiveData<UIState>()
    val data: LiveData<UIState>
    get() = _data

    fun getRestaurantList(latitude: Double, longitude: Double){
        repository.getRestaurantList(latitude, longitude)
        viewModelScope.launch {
            repository.restaurant.collect {
                _data.value = it
            }
        }
    }
}