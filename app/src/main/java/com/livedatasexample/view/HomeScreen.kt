package com.livedatasexample.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.livedatasexample.R
import com.livedatasexample.model.Meme
import com.livedatasexample.model.StoriesResponse
import com.livedatasexample.ui.theme.LiveDatasExampleTheme

//HomeScreen.kt
@Composable
fun HomeScreen(){
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){
        GreetingPreview()
    }
}

@Preview
@Composable
fun GreetingPreview() {
        Column {
            HeaderUI()
            StoriesRecycle()
            FinalPostRecycle()
        }
}

@Composable
fun FinalPostRecycle() {
    var stories: MutableList<StoriesResponse>
    stories = mutableListOf(
        StoriesResponse(userName = "v_tailor", userProfile = ""),
        StoriesResponse(userName = "siya", userProfile = ""),
        StoriesResponse(userName = "kiara", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "shreya", userProfile = ""),
        StoriesResponse(userName = "rohini", userProfile = "")
    )
    LazyColumn {
        items(stories) {
            FinalPostPreview(stories)
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ListItems(data: Meme) {
    Row {
        Column {
            GlideImage(
                model = data.url,
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .padding(10.dp)
                    .width(200.dp)
            ) {
                it
                    .load(data.url)
            }

        }

    }
}

@Composable
fun HeaderUI() {
    Row(modifier = Modifier.padding(10.dp)) {
        Text(
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            modifier = Modifier.weight(1F)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(
                painter = painterResource(R.drawable.icon_heart),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(20.dp),

                )
            Image(
                painter = painterResource(R.drawable.icon_chat),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun StoriesRecycle() {
    var stories: MutableList<StoriesResponse>
    stories = mutableListOf(
        StoriesResponse(userName = "v_tailor", userProfile = ""),
        StoriesResponse(userName = "siya", userProfile = ""),
        StoriesResponse(userName = "kiara", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "shreya", userProfile = ""),
        StoriesResponse(userName = "rohini", userProfile = "")
    )
    LazyRow {
        items(stories) {
            Stories(it)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Stories(stories: StoriesResponse) {
    Column(
        modifier = Modifier.padding(10.dp, 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            border = BorderStroke(1.dp, color = Color.Red),
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
        ) {
            GlideImage(
                model = Any(),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(65.dp)
                    .fillMaxWidth()

            ) {
                it
                    .load(R.drawable.icon_chat)
            }
        }
        Text(
            text = stories.userName,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PostPreview() {
    Row(
        modifier = Modifier
            .padding(0.dp, 5.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        //  .fillMaxHeight(),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
                .padding(5.dp, 0.dp, 0.dp, 0.dp)

        ) {
            Card(
                shape = CircleShape,
                border = BorderStroke(1.dp, color = Color.Red)
            ) {
                GlideImage(
                    model = Any(),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier
                        .size(60.dp)
                        .fillMaxWidth()
                ) {
                    it
                        .load(R.drawable.icon_chat)
                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp, 1.dp, 5.dp),
            ) {
                Text(
                    text = "userName",
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp
                )
                Text(
                    text = "Indore",
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, color = Color.Gray),
                colors = CardDefaults.cardColors(contentColor = Color.Black),
                modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 5.dp)

            ) {
                Text(
                    text = "Follow",
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp, 5.dp)

                )
            }

            Image(
                painter = painterResource(R.drawable.ic_more),
                contentDescription = stringResource(R.string.more),
                modifier = Modifier.size(18.dp)
            )
        }

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PostContent(stories: StoriesResponse) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp, 5.dp),
//        // .width(200.dp)
//    )
    //  {
    GlideImage(
        model = Any(),
        contentDescription = stringResource(R.string.app_name),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(0.dp, 5.dp)
    ) {
        it
            .load(R.drawable.img_dummy)
    }
    //  }

}

@Composable
fun PostRecycle(stories: MutableList<StoriesResponse>) {
    var stories: MutableList<StoriesResponse>
    stories = mutableListOf(
        StoriesResponse(userName = "v_tailor", userProfile = ""),
        StoriesResponse(userName = "siya", userProfile = ""),
        StoriesResponse(userName = "kiara", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "amaya", userProfile = ""),
        StoriesResponse(userName = "shreya", userProfile = ""),
        StoriesResponse(userName = "rohini", userProfile = "")
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(stories) {
            PostContent(it)
        }
    }
}

@Composable
fun LikeCommentShareSave() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.icon_heart),
                contentDescription = stringResource(R.string.like),
                modifier = Modifier.size(20.dp),
            )
            Image(
                painter = painterResource(R.drawable.ic_comment),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(20.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_send),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(20.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_save),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier.size(20.dp),
        )
    }
}

@Composable
fun CaptionsOfPost() {

    Row {
        //  SubCaption()
        OverlappingImages()
    }
    Text(
        text = "Indore",
        color = Color.Gray,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        modifier = Modifier.padding(start = 5.dp)
    )

}


@Composable
fun OverlappingImages() {
    Row(
        modifier = Modifier
            .padding(5.dp, 0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_dummy),
            contentDescription = "uu",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .clip(shape = CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.img_dummy),
            contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .offset(x = (-20).dp)
                .clip(shape = CircleShape)
        )
        Text(
            text = "Moon is so attractive. Moon is so peace and calm and the color of moon is white and there is a different types of moon we see in the sky like half moon and full moon",
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 0.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            maxLines = 2,
            lineHeight = 12.sp
        )
    }
}

@Composable
fun FinalPostPreview(stories: MutableList<StoriesResponse>) {
    PostPreview()
    PostRecycle(stories)
    LikeCommentShareSave()
    CaptionsOfPost()
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SubCaption() {
    Box(modifier = Modifier.fillMaxWidth()) {
//        Card(
//            shape = CircleShape,
//            modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 5.dp)
//        ) {
        GlideImage(
            model = Any(),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .size(25.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))


        ) {
            it
                .load(R.drawable.img_dummy)
        }
        //    }
//        Card(
//            shape = CircleShape,
//            modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 5.dp)
//        ) {
        GlideImage(
            model = Any(),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .size(15.dp)
                .fillMaxWidth()

        ) {
            it
                .load(R.drawable.icon_chat)
        }
        //  }
    }
}

