package com.example.shaidullinar_02_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("name")
        val status = intent.getStringExtra("status")
        val messages = intent.getStringExtra("messages")

        val imageView = findViewById<ImageView>(R.id.user_image)
        val userNameText = findViewById<TextView>(R.id.user_name)
        val userStatusText = findViewById<TextView>(R.id.user_status)
        val userMessagesCount = findViewById<TextView>(R.id.user_messages)

        imageView.setImageResource(R.drawable.user1)
        userNameText.text = name
        userStatusText.text = status
        userMessagesCount.text = messages
    }
}