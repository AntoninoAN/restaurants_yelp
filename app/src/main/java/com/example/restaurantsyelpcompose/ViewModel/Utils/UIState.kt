package com.example.restaurantsyelpcompose.ViewModel.Utils

sealed class UIState {

    object Loading: UIState()
    class Failure(val errorMessage: String): UIState()
    data class Success (val response: String): UIState()
    object Empty: UIState()

}
