package com.example.shaidullinar_02_06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class ChatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        val userList = listOf(
            UserType("John Joshua", "Thanks for your service", "", 1),
            UserType("Chinonso James", "Alright, I wll be waiting", "", 0),
            UserType("Raph Ron", "Thanks for your service", "", 5),
            UserType("Joy Ezekiel", "Thanks for your service", "", 0),
            UserType("Joy Ezekiel", "Thanks for your service", "", 1),
        )

        val listView = findViewById<ListView>(R.id.userList)
        listView.adapter = UserAdapter(this, userList)

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = userList[position]
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", selectedItem.name)
            intent.putExtra("status", selectedItem.status)
            intent.putExtra("avatar", selectedItem.avatar)
            intent.putExtra("message", selectedItem.messageCount)
            startActivity(intent)
        }
    }
}