package com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenTopAppBar() {
    androidx.compose.material.TopAppBar {
        Text(
            "Home Screen", textAlign = TextAlign.Center,
            modifier = Modifier.padding(12.dp)
        )
    }
}