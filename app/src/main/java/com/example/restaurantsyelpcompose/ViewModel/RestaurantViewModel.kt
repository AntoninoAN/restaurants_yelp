package com.example.restaurantsyelpcompose.ViewModel

import android.location.Location
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState
import com.example.restaurantsyelpcompose.rest.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class RestaurantViewModel(private val restaurantsRepository: Repository): ViewModel() {

    private val _data = MutableLiveData<UIState>()
    val data: LiveData<UIState>
    get() = _data

    //default state as empty
    var restaurantUIState: UIState = UIState.Empty

    //Functions to call for network request
    fun getRestaurantList (location: Location) {

        viewModelScope.launch {
             restaurantUIState = UIState.Loading
             restaurantUIState = try {
                 UIState.Success(restaurantsRepository.getRestaurantList(location))
             } catch (e: IOException) {
                 UIState.Failure("$e")
             } catch (e: HttpException) {
                 UIState.Failure("$e")
             }
        }
    }

    fun getRestaurantDetails (uid: String) {
        viewModelScope.launch {
            restaurantUIState = UIState.Loading
            restaurantUIState = try {
                UIState.Success(restaurantsRepository.getRestaurantDetails(uid))
            } catch (e: IOException) {
                UIState.Failure("$e")
            } catch (e: HttpException) {
                UIState.Failure("$e")
            }
        }
    }
}