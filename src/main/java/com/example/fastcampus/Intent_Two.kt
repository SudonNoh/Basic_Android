package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Intent_Two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        // intent 로 넘어온 데이터를 사용
        // Intent_One -> Intent_Two
        val intent = intent
        val data: String? = intent.extras?.getString("extra-data")
        if (data != null) {
            Log.d("dataa", data)
        }
    }
}