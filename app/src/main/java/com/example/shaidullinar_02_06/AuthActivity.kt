package com.example.shaidullinar_02_06

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class AuthActivity : AppCompatActivity() {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var authButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        loginEditText = findViewById(R.id.login_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        authButton = findViewById(R.id.auth_button)
        sharedPreferences = getSharedPreferences("userStore", MODE_PRIVATE)

        authButton.setOnClickListener { handleAuthClick() }
    }

    private fun handleAuthClick() {
        val login = loginEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (login.isEmpty() || password.isEmpty()) {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Ошибка")
            dialogBuilder.setMessage("Введите данные о пользователе")
            dialogBuilder.setPositiveButton("ОК") {
                dialog, id -> {}
            }
            dialogBuilder.show()
            return
        }

        val savedLogin = sharedPreferences.getString("login", "")
        val savedPassword = sharedPreferences.getString("password", "")

        if (TextUtils.isEmpty(savedLogin)) {
            sharedPreferences.edit()
                .putString("login", login)
                .putString("password", password)
                .apply()
            startActivity(Intent(this, ChatsActivity::class.java))
            return
        }

        if (login != savedLogin || password != savedPassword) {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Ошибка")
            dialogBuilder.setMessage("Неверный логин или пароль")
            dialogBuilder.setPositiveButton("ОК") {
                    dialog, id -> {}
            }
            dialogBuilder.show()
            return
        }

        startActivity(Intent(this, ChatsActivity::class.java))
        return
    }
}