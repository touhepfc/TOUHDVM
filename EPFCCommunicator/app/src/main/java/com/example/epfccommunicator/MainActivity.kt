package com.example.epfccommunicator

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import android.graphics.Bitmap as Bitmap

class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 15154
    private var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendButtonClicked(view: View) {

        val messageEditText : EditText = findViewById(R.id.TextView1_A1)
        val editTextString = messageEditText.text.toString()
        val context : Context = this
        val intent = Intent(context,ReceiveMessageActivity ::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, editTextString)
        startActivity(intent)

    }

    fun onShareButtonClicked(view: View) {

        val messageEditText : EditText = findViewById(R.id.TextView1_A1)
        val editTextString = messageEditText.text.toString()
        val intent  = Intent (Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, editTextString)
        startActivity(intent)


    }

    fun onSearchButtonClicked(view: View) {

        val messageEditText : EditText = findViewById(R.id.TextView2_A1)
        val mon_adresse = messageEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$mon_adresse")
        val intent  = Intent (Intent.ACTION_VIEW,addressUri)
        startActivity(intent)

    }

    fun onTAKEPICTUREButtonClicked(view: View) {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){


        if (data != null) {


            val extras  = data.extras
            if (extras != null) {
                 imageBitmap = extras.get("data") as Bitmap
                val imageView: ImageView = findViewById(R.id.imageview1_A1)
                imageView.setImageBitmap(imageBitmap)
            }
        }

    }

    fun onSizeButtonClicked(view: View) {

        val image : Bitmap? = imageBitmap
        if (image != null) {
                val stream  = ByteArrayOutputStream()
            image.compress(Bitmap.CompressFormat.PNG,100,stream)
            val byarray = stream.toByteArray()
            val intent = Intent(this, FullImageActivity::class.java)
            intent.putExtra("photo",byarray)
            startActivity(intent)
        }

    }
}
