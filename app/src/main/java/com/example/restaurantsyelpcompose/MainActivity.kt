package com.example.restaurantsyelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.HomeScreen
import com.example.restaurantsyelpcompose.ui.theme.RestaurantsYelpComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp {
                val navController = rememberNavController()
                val pagerState: PagerState = rememberPagerState()
                val coroutineScope: CoroutineScope = rememberCoroutineScope()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(route = "home") {
                        HomeScreen(pagerState,coroutineScope)
                    }
                }//matthew testing in forked project
            }
        }
    }
}

@Composable
fun MainApp(content: @Composable () -> Unit) {
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