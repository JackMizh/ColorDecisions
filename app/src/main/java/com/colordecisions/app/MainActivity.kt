package com.colordecisions.app

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sample)
        val pixels = IntArray(bitmap.width * bitmap.height)

        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        val isColorful = ImageColorChecker.filterImage(pixels, bitmap.width, bitmap.height)

        if (isColorful) {
            Toast.makeText(this, "This image is more colorful", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "This image is more black-white", Toast.LENGTH_LONG).show()
        }
    }
}