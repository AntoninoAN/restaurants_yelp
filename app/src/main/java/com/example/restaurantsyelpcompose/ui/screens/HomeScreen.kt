package com.example.restaurantsyelpcompose.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {

    val tempListOfRestaurants = listOf("Chipotle", "Taco Bell", "MacDonal")
    MessageList(tempListOfRestaurants)

}

@Composable
fun MessageList(messages: List<String>) {
    LazyColumn {
        items(messages) { message ->
            Text(message)
        }
    }
}