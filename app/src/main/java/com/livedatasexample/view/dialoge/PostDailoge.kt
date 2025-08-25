package com.livedatasexample.view.dialoge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.livedatasexample.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Preview(showSystemUi = true)
fun PostDailoge(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(

           usePlatformDefaultWidth = false ,
        ),
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                ,
        ) {

                Column(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth()
                ) {

                    Row {
                        GlideImage(
                            model = Any(),
                            contentDescription = stringResource(R.string.app_name),
                            modifier = Modifier
                                .size(50.dp)
                                .fillMaxWidth()
                                .padding(5.dp)
                                .clip(CircleShape)
                                ,
                            contentScale = ContentScale.Crop
                        ) {
                            it
                                .load(imageDescription)
                        }
                        Text (
                            text = "Indore",
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontSize = 15.sp,
                            modifier = Modifier.padding(10.dp, 2.dp, 0.dp, 0.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    GlideImage(
                        model = null,
                        contentDescription = stringResource(R.string.app_name),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ) {
                        it.load(imageDescription)
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp , bottom = 15.dp)
                        ,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.icon_heart),
                            contentDescription = stringResource(R.string.like),
                            modifier = Modifier.size(22.dp)
                                .weight(1F),
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_comment),
                            contentDescription = stringResource(R.string.app_name),
                            modifier = Modifier.size(22.dp)
                                .weight(1F)
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_send),
                            contentDescription = stringResource(R.string.app_name),
                            modifier = Modifier.size(22.dp)
                                .weight(1F)
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_more),
                            contentDescription = stringResource(R.string.more),
                            modifier = Modifier.size(21.dp)
                                .weight(1F)
                        )
                    }
                }
        }
    }
}
