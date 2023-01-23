package com.example.restaurantsyelpcompose.utils

sealed class UIState{
    object LOADING: UIState()
    class FAILURE(val e: Exception): UIState()
    class SUCCESS (val response: String)
}
