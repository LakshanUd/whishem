package com.example.wishem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnBoarding_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextBtn = findViewById<Button>(R.id.getStart)
        nextBtn.setOnClickListener {
            val intent = Intent(this, Log_in::class.java)
            startActivity(intent)
        }


        val backImage = findViewById<ImageView>(R.id.imageback2)
        backImage.setOnClickListener {
            val intent = Intent(this, OnBoarding_2::class.java)
            startActivity(intent)
        }
    }
}