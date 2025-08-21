package com.livedatasexample.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationResponse (
    val title : String ,
    val icon : ImageVector,
    val route : String
)
