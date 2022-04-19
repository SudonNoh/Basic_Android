package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide


class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        val imageView = findViewById<ImageView>(R.id.image)
        Glide.with(this)
            .load("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fc80aWI%2Fbtrwhc3ByGL%2FzbpcDvwpdhrdofavIYuj2k%2Fimg.png")
            .centerInside()
            .into(imageView)
    }
}