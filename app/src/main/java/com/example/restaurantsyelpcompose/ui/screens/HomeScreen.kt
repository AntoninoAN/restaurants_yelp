package com.example.restaurantsyelpcompose.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsyelpcompose.MainApp

@Composable
fun HomeScreen() {

}

@Composable
fun HomeScreenContentLoading(isLoading: Boolean) {
    //is loading display progress bar
    //not loading hide progress bar
    AnimatedVisibility(visible = isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.padding(4.dp),
                    strokeWidth = 10.dp
        )//matthew was here
    }
}

@Preview
@Composable
fun PreviewHomeScreenLoading(){
    MainApp {
        HomeScreenContentLoading(isLoading = true)
    }
}