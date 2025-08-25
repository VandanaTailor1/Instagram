package com.livedatasexample.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.dp
import com.livedatasexample.R
import com.progressbars.DottedCircularProgressBar1

//CartScreen.kt
@Composable
fun CartScreen(){
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Cart Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

//SettingScreen
@Composable
@Preview(showSystemUi = true)
fun SettingScreen(){

    Box (modifier = Modifier
        .fillMaxSize(
        )
        .background(Color.White),
        contentAlignment = Alignment.Center,

    ){
        DottedCircularProgressBar1(
            iconRes = R.drawable.icon_heart
        )
    }
}

@Composable
fun BouncingDotProgressIndicator(
    modifier: Modifier = Modifier,
    initialColor: Color = Color.Yellow,
    animatedColor: Color = Color.Magenta
) {
    val dotAnimatables = remember {
        listOf(
            Animatable(0f),
            Animatable(0f),
            Animatable(0f)
        )
    }
    dotAnimatables.forEachIndexed { index, animatable ->

        LaunchedEffect(key1 = animatable) {
            animatable.animateTo(
                targetValue = 1f, animationSpec = infiniteRepeatable(
                    initialStartOffset = StartOffset(index * 150),
                    animation = keyframes {
                        durationMillis = 1000
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0f at 700 with LinearOutSlowInEasing
                        0f at 1000
                    },
                    repeatMode = RepeatMode.Restart,
                )
            )
        }
    }

    val sameColor = initialColor == animatedColor

    Canvas(
        modifier
            .progressSemantics()
            .size(10.dp, 10.dp)
            .padding(8.dp)
    ) {
        val canvasWidth = size.width

        val space = canvasWidth * 0.1f
        val diameter = (canvasWidth - 2 * space) / 3
        val radius = diameter / 2

        dotAnimatables.forEachIndexed { index, animatable ->
            val x = radius + index * (diameter + space)
            val value = animatable.value

            drawCircle(
                color = if (sameColor) initialColor else lerp(
                    initialColor,
                    animatedColor,
                    value
                ),
                center = Offset(
                    x = x,
                    y = center.y - radius * value * 1.6f
                ),
                radius = radius
            )
        }
    }
}

/**
 * Dot progress indicator that draws 3 dots that constantly changing radius after the one
 * next to it. If [initialColor] and [animatedColor] are not same colors color is animated
 * from [initialColor] to [animatedColor]
 *
 * @param initialColor color that is initially set with animation
 * @param animatedColor color that is set after animation
 */
@Composable
fun DotProgressIndicator(
    modifier: Modifier = Modifier,
    initialColor: Color = Color.Black,
    animatedColor: Color = Color.Red
) {

    val initialValue = 0.25f

    val dotAnimatables = remember {
        listOf(
            Animatable(initialValue),
            Animatable(initialValue),
            Animatable(initialValue)
        )
    }
    dotAnimatables.forEachIndexed { index, animatable ->

        LaunchedEffect(key1 = animatable) {
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    initialStartOffset = StartOffset(index * 300),
                    animation = tween(600, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Reverse,
                )
            )
        }
    }

    val sameColor = initialColor == animatedColor

    Canvas(
        modifier
            .progressSemantics()
            .size( 10.dp, 10.dp)
            .padding(8.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val diameter = (canvasHeight / 2).coerceAtLeast(canvasWidth / 3)
        val radius = diameter / 2

        dotAnimatables.forEachIndexed { index, animatable ->
            val x = radius + index * (diameter)
            val value = animatable.value
            val colorFraction =
                scale(start1 = initialValue, end1 = 1f, pos = value, start2 = 0f, end2 = 1f)

            drawCircle(
                color = if (sameColor) initialColor.copy(alpha = value) else
                    lerp(
                        initialColor,
                        animatedColor,
                        colorFraction
                    ),
                center = Offset(
                    x = x,
                    y = center.y
                ),
                radius = radius * value
            )
        }
    }
}

internal fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return (1 - fraction) * start + fraction * stop
}

/**
 * Scale pos from start1..end1 range to start2..end2 range
 * 50 in [0-100] interval is scaled to 150 in [100-200] interval.
 */
internal fun scale(start1: Float, end1: Float, pos: Float, start2: Float, end2: Float) =
    lerp(start2, end2, calculateFraction(start1, end1, pos))

/**
 * Calculate fraction for value between a range [end] and [start] coerced into 0f-1f range
 */
internal fun calculateFraction(start: Float, end: Float, pos: Float) =
    (if (end - start == 0f) 0f else (pos - start) / (end - start)).coerceIn(0f, 1f)