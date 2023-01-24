package com.example.restaurantsyelpcompose.ui.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.restaurantsyelpcompose.ui.screens.homeScreen.uiComponents.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,

    ) {
    Scaffold(
        topBar = {
            HomeScreenTopAppBar()
        }
    ) {

        Column {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = MaterialTheme.colors.secondary
                    )
                },
            ) {
                tabRowItems.forEachIndexed { index, item ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "")
                        },
                        text = {
                            Text(
                                text = item.title,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                count = tabRowItems.size,
                state = pagerState,
            ) {
                tabRowItems[pagerState.currentPage].screen()
            }
        }
    }
}


@Composable
fun view() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
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

val tabRowItems = listOf(
    TabRowItem(
        title = "Hot",
        screen = { HomeScreenTab(view()) },
        icon = Icons.Default.Home,
    ),
    TabRowItem(
        title = "New",
        screen = { HomeScreenTab(view()) },
        icon = Icons.Filled.Warning,
    ),
)