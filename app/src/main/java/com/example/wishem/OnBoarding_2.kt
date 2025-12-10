package com.example.wishem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnBoarding_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nextBtn = findViewById<Button>(R.id.nxtBtn2)
        nextBtn.setOnClickListener {
            val intent = Intent(this, OnBoarding_3::class.java)
            startActivity(intent)
        }

        val backImage = findViewById<ImageView>(R.id.imageback1)
        backImage.setOnClickListener {
            val intent = Intent(this, OnBoarding_1::class.java)
            startActivity(intent)
        }

    }
}