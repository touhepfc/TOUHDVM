package com.example.epfccommunicator

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class FullImageActivity : AppCompatActivity() {
    private var isInFillMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val intent = intent

        if (intent.hasExtra("photo")) {

            val byteArray = intent.getByteArrayExtra("photo")

            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

            val imageView : ImageView = findViewById(R.id.imageview1_A3)
            imageView.setImageBitmap(bitmap)



        }


    }

    fun onSizeclicked(view: View) {

        isInFillMode = !isInFillMode
        val imageView = view as ImageView

        if (isInFillMode) {
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        }


    }
}
