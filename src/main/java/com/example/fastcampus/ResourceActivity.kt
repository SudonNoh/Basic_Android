package com.example.fastcampus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        findViewById<TextView>(R.id.text).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)
//            it.background = resources.getDrawable(R.drawable.key_button)

//            it.background = resources.getDrawable(R.drawable.key_button, null)
//            현재 테마를 가져오는 방법: this.theme
//            it.background = resources.getDrawable(R.drawable.key_button, this.theme)
//            it.background = ContextCompat.getDrawable(this, R.drawable.key_button)
//            it.background = ResourcesCompat.getDrawable(resources, R.drawable.key_button, null)
        }
    }
}