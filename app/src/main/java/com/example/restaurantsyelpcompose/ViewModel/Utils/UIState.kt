package com.example.restaurantsyelpcompose.ViewModel.Utils

sealed class UIState {

    object Loading: UIState()
    class Failure(val errorMessage: String): UIState()
    data class Success<T: Any> (val response: T): UIState()
    object Empty: UIState()

}
