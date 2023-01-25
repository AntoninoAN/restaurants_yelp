package com.example.restaurantsyelpcompose.ui.screens.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restaurantsyelpcompose.ViewModel.RestaurantViewModel
import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState
import com.example.restaurantsyelpcompose.model.BusinessDetail
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.HomeScreenTopAppBar

import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.RestaurantCard


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: RestaurantViewModel,
                navController: NavController) {
    val restaurantListState = viewModel.data.observeAsState().value
    Scaffold(
        topBar = {
            HomeScreenTopAppBar()
        }
    ) {
        when (restaurantListState){
            is UIState.Success<*> -> {
                RestaurantList(restaurantListState?.response as List<BusinessDetail>) {
                    navController.navigate("details/$it")
                }
            }
            is UIState.Failure -> ErrorContent(restaurantListState.errorMessage)
            is UIState.Loading -> LoadingContent()
        }
    }

}

@Composable
fun LoadingContent() {

}

@Composable
fun ErrorContent(errorMessage: String) {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantList(response: List<BusinessDetail>,
                    showRestaurantDetails: (String?)-> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(1),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        //Pending:
        //Inside Items will be the list of restaurants
        //RestaurantCard() will acept a restaurant object to be displayed
        items(response.size) {businessDetail->
            RestaurantCard(response[businessDetail], showRestaurantDetails)
        }
    }
}
