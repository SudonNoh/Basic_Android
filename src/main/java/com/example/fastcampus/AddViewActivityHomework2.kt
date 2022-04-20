package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AddViewActivityHomework2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view_homework2)

        val intent = intent
        val blogName: String? = intent.extras?.getString("blogName")
        val blogNumber: String? = intent.extras?.getString("blogNumber")

        val detail = findViewById<TextView>(R.id.detail)
        detail.text = blogName + "\n" + blogNumber
    }
}