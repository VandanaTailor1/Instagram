package com.livedatasexample.view.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.livedatasexample.R
import com.livedatasexample.view.dialoge.PostDailoge
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
@Preview(showSystemUi = true)
fun SearchScreen(
    searchQuery : String
) {
    Column {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {},
            leadingIcon = {
                Icon(
                    rememberVectorPainter(Icons.Default.Search),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 2.dp)
                )
            },
            placeholder = {
                Text("Search", fontSize = 14.sp, color = Color.Black)
            },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .onFocusChanged { focusState ->
                },
            shape = RoundedCornerShape(15.dp),
            singleLine = true
        )

        val listPost = mutableListOf(
            "https://i.pinimg.com/236x/56/61/22/56612276626e05af64de9649723982f2.jpg",
            "https://images.pexels.com/photos/250591/pexels-photo-250591.jpeg?cs=srgb&dl=pexels-jmark-250591.jpg&fm=jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYYKUbakdgQzSpfKk1YfNUyyZITZdKuEwFaQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOAbesiqwx810w81hNnFZfSHQH1L4vKN4b9A&s",
            "https://images.pexels.com/photos/250591/pexels-photo-250591.jpeg?cs=srgb&dl=pexels-jmark-250591.jpg&fm=jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYYKUbakdgQzSpfKk1YfNUyyZITZdKuEwFaQ&s",
            "https://i.pinimg.com/236x/d2/7b/28/d27b28347d79ddfa4fa701c0e52115f8.jpg",
            "https://i.pinimg.com/736x/09/0d/96/090d967491c49263671c6a94a6acd750.jpg",
            "https://images.pexels.com/photos/14401/pexels-photo-14401.jpeg?cs=srgb&dl=pexels-valeriya-14401.jpg&fm=jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7ecwTv8_xvrMTQvFq3L2SV1cFD6zudACFTg&s",
            "https://i.pinimg.com/736x/a2/7f/aa/a27faa18f134ebae67f60f1421f83ac5.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYYKUbakdgQzSpfKk1YfNUyyZITZdKuEwFaQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYYKUbakdgQzSpfKk1YfNUyyZITZdKuEwFaQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYYKUbakdgQzSpfKk1YfNUyyZITZdKuEwFaQ&s"
        )

        LazyVerticalStaggeredGrid  (
             columns = StaggeredGridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 10.dp),
           horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalItemSpacing = 2.dp
        ) {
           items(listPost) {
               FeedPostAndReels(it)
           }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable()
fun FeedPostAndReels(url: String) {
    val randomHeight = remember { (100..250).random().dp }
    Box {
        GlideImage(
            model = url,
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .fillMaxWidth()
                .height(randomHeight)
                .clickable(
                ) { Log.d("123456", "Feed Post: ") },
            contentScale = ContentScale.Crop
        )
    }
}
