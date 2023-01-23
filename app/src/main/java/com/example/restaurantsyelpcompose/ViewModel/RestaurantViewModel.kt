package com.example.restaurantsyelpcompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState

class RestaurantViewModel: ViewModel() {

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
}