package com.example.epfccommunicator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReceiveMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)

        val textToDisplay = intent.getStringExtra(Intent.EXTRA_TEXT)
        val textView : TextView = findViewById(R.id.TextView1_A2)
        textView.text = textToDisplay
    }
}
