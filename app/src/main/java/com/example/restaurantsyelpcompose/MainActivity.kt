
package com.example.restaurantsyelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsyelpcompose.ViewModel.RestaurantViewModel
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.HomeScreen
import com.example.restaurantsyelpcompose.ui.theme.RestaurantsYelpComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp {
                val navController = rememberNavController()
                val viewModel: RestaurantViewModel by viewModels()

                NavHost(navController = navController,
                    startDestination = "home") {
                    composable(route = "home") {
                        HomeScreen(viewModel, navController)
                    }
                }//matthew testing in forked project
            }
        }
    }
}

@Composable
fun MainApp(content: @Composable ()->Unit) {
    RestaurantsYelpComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainApp {
        Greeting("Android")
    }
}