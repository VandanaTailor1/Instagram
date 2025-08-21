package com.livedatasexample.view.profilestabs

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.livedatasexample.R
import com.livedatasexample.view.FinalPostPreview

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview(showSystemUi = true)
fun PostView() {
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(listPost) {
             ListMyPost(it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable()
fun ListMyPost(url : String) {
    Box {
        GlideImage(
            model = Any(),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clickable { Log.d("123456", "ListMyPost: ") }
            ,
            contentScale = ContentScale.Crop
        ) {
            it
                .load(url)
        }

        Icon(
            painter = rememberVectorPainter(image = Icons.Default.Email) ,
            contentDescription = "post_icon" ,
            modifier = Modifier
                .height(25.dp)
                .width(25.dp)
                .align(Alignment.TopEnd)
                .padding(top = 3.dp)
        )
    }


}