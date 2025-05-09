package com.roman_kulikov.module_4_practice.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.Random


class ColorFillRectangle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {
    private var fillPercent = 0
    private var fillColor = randomColor()

    private val borderPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLACK
        strokeWidth = 4f
        isAntiAlias = true
    }

    private val fillPaint = Paint().apply {
        style = Paint.Style.FILL
        color = fillColor
        isAntiAlias = true
    }

    init {
        setOnClickListener {
            fillPercent += 10
            if (fillPercent > 100) {
                fillPercent = 0
            }
            fillColor = randomColor()
            fillPaint.color = fillColor
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), borderPaint)

        val filledWidth = width * (fillPercent / 100f)
        canvas.drawRect(0f, 0f, filledWidth, height.toFloat(), fillPaint)
    }

    fun setFillPercent(percent: Int) {
        fillPercent = percent
        fillColor = randomColor()
        fillPaint.color = fillColor
        invalidate()
    }

    fun setFillPercent(percent: Int, color: Int) {
        fillPercent = percent
        fillPaint.color = color
        invalidate()
    }

    private fun randomColor(): Int {
        val rnd = Random()
        return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}