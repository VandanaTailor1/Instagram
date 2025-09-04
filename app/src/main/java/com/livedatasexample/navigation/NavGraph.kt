package com.livedatasexample.navigation

import android.content.Context
import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.livedatasexample.utils.ProfileTabsScreen
import com.livedatasexample.utils.Screen
import com.livedatasexample.view.HomeScreen
import com.livedatasexample.view.PostPreview
import com.livedatasexample.view.ProfileScreen
import com.livedatasexample.view.profilestabs.PostView

@Composable
fun NavGraph(
    navHostController: NavHostController ,
    context: Context
) {
     NavHost(navController = navHostController ,
         startDestination = Screen.Home.route) {
         composable (route = Screen.Home.route) {
             //HomeScreen()
         }
     }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ProfileTabsScreen.Post.route,
        modifier = modifier
    ) {
        composable(ProfileTabsScreen.Post.route) { PostView() }
        composable(ProfileTabsScreen.Reels.route) { PostView() }
        composable(ProfileTabsScreen.Tags.route) { PostView() }
    }
}
