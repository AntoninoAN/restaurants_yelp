package com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantCard() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)

    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("The name of the restaurant")
            Text("The \$ of the restaurant")
            Text("An image url of the restaurant")
            Text("The rating of the restaurant")
            Text("How far away the restaurant is from the user’s current location in miles")
        }
    }


}