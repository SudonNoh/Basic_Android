package com.example.fastcampus

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

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

        (findViewById<TextView>(R.id.finish)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent()
                intent.putExtra("result", "success")
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        // Intent_One에서 보낸 Image를 Uri 형태로 다시 받은 부분
        // 이유: ImageView에서 이미지를 바꿔줄 때 Uri가 필요
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        imageView.setImageURI(uri)

    }
}