package com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.restaurantsyelpcompose.model.BusinessDetail

@Composable
fun RestaurantCard(businessDetail: BusinessDetail,
                   showDetails: (String?)-> Unit) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)
            .clickable { showDetails(businessDetail.id) }
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("${businessDetail.name}")
            Text("${businessDetail.price}")
            Text("An image url of the restaurant")
            Text("${businessDetail.rating}")
            Text("${businessDetail.distance}")
        }
    }


}