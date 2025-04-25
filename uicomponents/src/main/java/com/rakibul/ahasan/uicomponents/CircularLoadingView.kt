package com.rakibul.ahasan.uicomponents

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.cos
import kotlin.math.sin

class CircularLoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dotCount = 12
    private val animDuration = 1000L
    private val dotRadius = 10f
    private val radius = 50f

    private var animator: ValueAnimator? = null
    private var progress = 0f

    init {
        startAnimation()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val angleStep = (2 * Math.PI / dotCount)
        for (i in 0 until dotCount) {
            val angle = i * angleStep
            val x = (width / 2 + radius * cos(angle)).toFloat()
            val y = (height / 2 + radius * sin(angle)).toFloat()

            val alpha = ((i + progress * dotCount) % dotCount) / dotCount
            paint.color = Color.GRAY
            paint.alpha = (alpha * 255).toInt()
            canvas.drawCircle(x, y, dotRadius, paint)
        }
    }

    private fun startAnimation() {
        animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = animDuration
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                progress = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator?.cancel()
    }
}