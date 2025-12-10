package com.example.wishem

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Log_in : AppCompatActivity() {

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        emailEt = findViewById(R.id.email)
        passwordEt = findViewById(R.id.password)
        loginBtn = findViewById(R.id.login_btn)
        val signUp = findViewById<TextView>(R.id.sign_up)


        loginBtn.isEnabled = false
        loginBtn.alpha = 0.5f


        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) { toggleLoginEnabled() }
        }
        emailEt.addTextChangedListener(watcher)
        passwordEt.addTextChangedListener(watcher)


        signUp.setOnClickListener {
            startActivity(Intent(this, Sign_up::class.java))
        }

        val logBtn = findViewById<ImageView>(R.id.imageView4)
        logBtn.setOnClickListener {
            val intent = Intent(this, Home_Screen::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            startActivity(Intent(this, Home_Screen::class.java))
        }
    }

    private fun toggleLoginEnabled() {
        val emailFilled = emailEt.text?.trim()?.isNotEmpty() == true
        val passFilled = passwordEt.text?.trim()?.isNotEmpty() == true
        val enabled = emailFilled && passFilled
        loginBtn.isEnabled = enabled
        loginBtn.alpha = if (enabled) 1f else 0.5f
    }
}
