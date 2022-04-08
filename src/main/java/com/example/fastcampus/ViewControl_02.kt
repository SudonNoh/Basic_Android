package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)

        // View를 코틀린 파일(Activity)로 가져오는 방법
        val textViewOne: TextView = findViewById(R.id.textViewOne)
        val buttonOne: Button = findViewById(R.id.buttonOne)
        // textView를 불러와서 text로하면 CharSequence 형태로 온다. 따라서 toString 옵션을 사용
        Log.d("textView_test", textViewOne.text.toString())

        // Listener 사용 방법
        buttonOne.setOnClickListener {
            Log.d("buttonOne_test", "클릭1")
        }
        // 풀버전
        // val clickListener = object : View.OnClickListener {
        //     override fun onClick(p0: View?) {
        //         Log.d("_test", "클릭3")
        //     }
        // }
        // buttonOne.setOnClickListener(clickListener)

        textViewOne.setOnClickListener {
            Log.d("_test", "클릭2")
        }

    }
}