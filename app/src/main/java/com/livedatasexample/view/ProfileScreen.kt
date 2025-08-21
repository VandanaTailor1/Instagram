package com.livedatasexample.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabIndicatorScope
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.livedatasexample.R
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.livedatasexample.navigation.AppNavHost
import com.livedatasexample.ui.theme.Typography
import com.livedatasexample.utils.ProfileTabsScreen

//ProfileScreen.kt
@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Heading()
            ProfileViewAndEdit()
            CenterWorks()
        }
        Tabs()
    }
}

@Composable
fun Heading() {
    Row(modifier = Modifier.padding(0.dp, 10.dp)) {
        Icon(
            painter = rememberVectorPainter(Icons.Default.Lock),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier.height(20.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "android_dev",
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 5.dp)

        )
        Icon(
            painter = rememberVectorPainter(Icons.Default.KeyboardArrowDown),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .padding(start = 5.dp)

        )
        Spacer(
            modifier = Modifier.weight(1F)
        )

        Row {

            Icon(
                painter = painterResource(R.drawable.mention),
                contentDescription = "menu",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)

            )
            Icon(
                painter = painterResource(R.drawable.more),
                contentDescription = "menu",
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .height(20.dp)
                    .width(20.dp)
            )
            Icon(
                painter = rememberVectorPainter(Icons.Default.Menu),
                contentDescription = "menu",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)

            )

        }
    }
}

@Composable
fun ProfileViewAndEdit() {
    Row(modifier = Modifier.padding(top = 15.dp)) {
        Card(
            shape = CircleShape,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        ) {
            Row() {
                Box() {
                    Image(
                        painter = painterResource(R.drawable.img_dummy),
                        contentDescription = "Profile image",
                        modifier = Modifier
                            .shadow(5.dp)
                            .height(65.dp)
                            .width(65.dp),
                    )
                }
            }
        }
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(
                text = "android_dev",
                color = Color.Black,
                fontSize = 20.sp,
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Column(
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Text(
                        text = "1",
                        color = Color.DarkGray,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.Start),
                    )

                    Text(
                        text = "post",
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
                Column(
                    modifier = Modifier.padding(end = 15.dp)) {
                    Text(
                        text = "100",
                        color = Color.DarkGray,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.Start),
                    )

                    Text(
                        text = "followers",
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
                Column(
                    modifier = Modifier.padding(end = 15.dp)) {
                    Text(
                        text = "1",
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .align(Alignment.Start),
                    )

                    Text(
                        text = "following",
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
            }

        }

    }

}

@Composable
fun CenterWorks() {
    Row(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
    ) {

            Text(
                text = "Edit Profile",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier
                    .background(color = Color.DarkGray ,
                    shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp , vertical = 7.dp)
                    .weight(1f)
            )
        Text(
            text = "Share Profile",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 5.dp)
                .background(color = Color.DarkGray ,
                    shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp , vertical = 7.dp)
                .weight(1f)
        )
//            Text(
//                text = "Share Profile",
//                color = Color.White,
//                modifier = Modifier
//
        Icon(
            tint = Color.White,
            painter = rememberVectorPainter(Icons.Default.Face),
            contentDescription = "pr",
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 5.dp )
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.DarkGray)
                .padding(horizontal = 5.dp, vertical = 5.dp)


        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tabs() {

    val navController = rememberNavController()
    val startDestination = ProfileTabsScreen.Post
    var name: String
    var selectedDestination by rememberSaveable { mutableIntStateOf(0) }
    val profileTabs = listOf(
        ProfileTabsScreen.Post,
        ProfileTabsScreen.Reels,
        ProfileTabsScreen.Tags
    )

    Column(modifier = Modifier.padding(3.dp)) {
        PrimaryTabRow(
            selectedTabIndex = selectedDestination,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            divider = { },
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(
                        selectedDestination,
                        matchContentSize = false
                    ),
                    width = 80.dp,
                    color = Color.Black
                )
            },

            ) {
            profileTabs.forEachIndexed { index, destination ->
                Tab(
                    selected = selectedDestination == index,
                    onClick = {
                        if (selectedDestination != index) {
                            selectedDestination = index
                            navController.navigate(route = destination.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = rememberVectorPainter(destination.icon),
                            contentDescription = "tabicon"
                        )
                    }
                )
            }
        }

        AppNavHost(
            navController = navController,
            modifier = Modifier.weight(1f)
        )
    }
}
