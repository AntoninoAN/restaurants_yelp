package com.example.restaurantsyelpcompose.ui.screens.homeScreen

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.example.restaurantsyelpcompose.ViewModel.RestaurantViewModel
import com.example.restaurantsyelpcompose.ViewModel.Utils.UIState
import com.example.restaurantsyelpcompose.model.BusinessDetail
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.HomeScreenTopAppBar

import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.RestaurantCard
import com.google.android.gms.location.LocationServices


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: RestaurantViewModel,
                navController: NavController,
                requestPermission: ActivityResultLauncher<Array<String>>) {

    requestPermission.launch(arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    ))

    val locationService = LocationServices.getFusedLocationProviderClient(
        LocalContext.current)

    if (ActivityCompat.checkSelfPermission(
            LocalContext.current,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            LocalContext.current,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return
    }
    locationService.lastLocation.addOnSuccessListener {
        viewModel.getRestaurantList(it.latitude, it.longitude)
    }

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
