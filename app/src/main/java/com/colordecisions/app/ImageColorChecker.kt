package com.colordecisions.app

import android.graphics.Color

object ImageColorChecker {

    fun filterImage(pixels: IntArray, width: Int, height: Int): Boolean {
        var colorfulPixelCount = 0
        val totalPixelCount = width * height

        for (y in 0 until height) {
            for (x in 0 until width) {
                val index = y * width + x
                val pixel = pixels[index]
                val colorfulness = calculateColorfulness(pixel)
                if (colorfulness) {
                    colorfulPixelCount++
                }
            }
        }
        return colorfulPixelCount > totalPixelCount
    }

    private fun calculateColorfulness(pixel: Int): Boolean {
        val r: Int = Color.red(pixel)
        val g: Int = Color.green(pixel)
        val b: Int = Color.blue(pixel)
        val max = r.coerceAtLeast(g.coerceAtLeast(b))
        val min = r.coerceAtMost(g.coerceAtMost(b))

        val luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b

        return if((max - min) >= 30){
            luminance >= 40
        }else{
            false
        }
    }
}