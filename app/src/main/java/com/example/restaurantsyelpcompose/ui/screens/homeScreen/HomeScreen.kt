package com.example.restaurantsyelpcompose.ui.screens.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.HomeScreenTopAppBar

import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.RestaurantCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeScreenTopAppBar()
        }
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(1),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            //Pending:
            //Inside Items will be the list of restaurants
            //RestaurantCard() will acept a restaurant object to be displayed
            items(4) {
                RestaurantCard()
            }
        }
    }

}