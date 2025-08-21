package com.livedatasexample.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (var route: String) {
    data object Home : Screen("home_screen")
    data object Search : Screen("search")
    data object Post : Screen("post")
    data object Feed : Screen("feed")
    data object Profile : Screen("profile")
}

//sealed class ProfileTabsScreen(var route: String){
//    data object Post : ProfileTabsScreen("Post")
//    data object Reels : ProfileTabsScreen("Reels")
//    data object Tags : ProfileTabsScreen("Tags")
//}
sealed class ProfileTabsScreen(val route: String, val icon: ImageVector) {
    data object Post : ProfileTabsScreen("post",   Icons.Default.MailOutline)
    data object Reels : ProfileTabsScreen("reels",Icons.Default.Menu)
    data object Tags : ProfileTabsScreen("tags",  Icons.Default.AccountBox)
}