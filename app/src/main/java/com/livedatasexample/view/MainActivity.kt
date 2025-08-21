package com.livedatasexample.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.livedatasexample.model.NavigationResponse
import com.livedatasexample.ui.theme.LiveDatasExampleTheme
import com.livedatasexample.utils.Screen
import com.livedatasexample.viewmodel.MemeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val memeViewModel: MemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LiveDatasExampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { innerPadding ->

                    val graph = navController.createGraph(startDestination = Screen.Home.route) {
                        composable(route = Screen.Search.route) {
                            SettingScreen()
                        }
                        composable(route = Screen.Home.route) {
                            HomeScreen()
                        }
                        composable(route = Screen.Post.route) {
                            PostPreview()
                        }
                        composable(route = Screen.Feed.route) {
                            CartScreen()
                        }
                        composable(route = Screen.Profile.route) {
                            ProfileScreen()
                        }
                    }
                    NavHost(
                        navController = navController,
                        graph = graph,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }


        lifecycleScope.launch {
            println("Task 2: Start")
            Thread.sleep(2000) // blocking
            println("Task 2: End")
        }
        lifecycleScope. launch {
            println("Task 1: Start")
            delay(2000) // suspending
            println("Task 1: End")
        }

    }


}

private fun navigationValue(): List<NavigationResponse> {
    return listOf(
        NavigationResponse(
            title = "home",
            icon = Icons.Default.Home,
            route = Screen.Home.route
        ),
        NavigationResponse(
            title = "search",
            icon = Icons.Default.Search,
            route = Screen.Search.route
        ),
        NavigationResponse(
            title = "post",
            icon = Icons.Default.Add,
            route = Screen.Post.route
        ),
        NavigationResponse(
            title = "feed",
            icon = Icons.Default.MailOutline,
            route = Screen.Feed.route
        ),
        NavigationResponse(
            title = "profile",
            icon = Icons.Default.Person,
            route = Screen.Profile.route
        )

    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar(
        containerColor = Color.White
    ) {
        navigationValue().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
//                    navController.navigate(item.route)
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )

            )
        }
    }
}