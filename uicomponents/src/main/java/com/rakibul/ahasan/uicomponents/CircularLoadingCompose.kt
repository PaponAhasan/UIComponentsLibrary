package com.rakibul.ahasan.uicomponents

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CircularLoadingCompose(
    modifier: Modifier = Modifier,
    dotCount: Int = 12,
    dotRadius: Dp = 5.dp,
    radius: Dp = 25.dp,
    color: Color = Color.Gray,
    durationMillis: Int = 1000
) {
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    )

    val dotRadiusPx = with(LocalDensity.current) { dotRadius.toPx() }
    val radiusPx = with(LocalDensity.current) { radius.toPx() }

    Canvas(modifier = modifier) {
        val angleStep = (2 * Math.PI / dotCount)
        for (i in 0 until dotCount) {
            val angle = i * angleStep
            val x = center.x + radiusPx * cos(angle)
            val y = center.y + radiusPx * sin(angle)

            val alpha = ((i + progress * dotCount) % dotCount) / dotCount
            drawCircle(
                color = color.copy(alpha = alpha),
                radius = dotRadiusPx,
                center = Offset(x.toFloat(), y.toFloat())
            )
        }
    }
}

