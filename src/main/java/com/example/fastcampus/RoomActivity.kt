package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }
}

class User(
    val lastName: String,
    val firstName: String
)