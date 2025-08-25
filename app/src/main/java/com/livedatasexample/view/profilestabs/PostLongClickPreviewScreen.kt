package com.livedatasexample.view.profilestabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.livedatasexample.R


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Preview(showSystemUi = true)
fun PostLongClickPreviewScreen() {
    Column(modifier = Modifier.padding(top = 80.dp)
        .fillMaxSize()
        .background(Color.Black))
    {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            Row {
                GlideImage(
                    model = Any(),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier
                        .size(60.dp)
                        .fillMaxWidth()
                        .clip(CircleShape)

                ) {
                    it
                        .load(R.drawable.img_dummy)
                }

                Text(
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
                    .height(500.dp)
            ) {
                it.load(R.drawable.img_dummy)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_heart),
                    contentDescription = stringResource(R.string.like),
                    modifier = Modifier.size(30.dp)
                        .weight(1F),
                )
                Image(
                    painter = painterResource(R.drawable.ic_comment),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(30.dp)
                        .weight(1F)
                )
                Image(
                    painter = painterResource(R.drawable.ic_send),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(30.dp)
                        .weight(1F)
                )
                Image(
                    painter = painterResource(R.drawable.ic_more),
                    contentDescription = stringResource(R.string.more),
                    modifier = Modifier.size(28.dp)
                        .weight(1F)
                )
            }
        }
    }
}