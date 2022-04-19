package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        // 현재 thread가 어떤 thread인지 나옴
        val currentThread = Thread.currentThread()
        Log.d("testt", "A" + currentThread)

//        Thread {
//            for (a in 1..1000) {
//                Log.d("testt", "A" + a)
//            }
//        }.start()
//
//        Thread {
//            for (a in 1..1000) {
//                Log.d("testt", "B" + a)
//            }
//        }.start()

        Thread {
            val currentThread = Thread.currentThread()
            Log.d("testt", "A" + currentThread)
            // findViewById<TextView>(R.id.test_text).text = "changed"
            // UI 관련 작업을 main thread가 아닌 thread에서 하려고 하면 해당 작업 main thread의 queue로
            // 들어간다. 이 이유 때문에 오류가 발생하지 않을 수 있다.

            // UI thread에서 작업할 수 있는 것것
           runOnUiThread {
                findViewById<TextView>(R.id.test_text).text = "changed"
            }
        }.start()
    }
}