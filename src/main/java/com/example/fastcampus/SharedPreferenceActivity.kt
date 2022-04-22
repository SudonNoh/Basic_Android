package com.example.fastcampus

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference 사용법
        findViewById<TextView>(R.id.Create).setOnClickListener {
            // Create
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            // MODE
            // MODE_PRIVATE -> 현재 앱에서만 사용을 하겠다 -> 다른 앱과 공유하지 않겠다.
            // MODE_WORLD_READBLE: 다른 앱에서도 사용 가능(읽기)
            // MODE_WORLD_WRITABLE: 다른 앱에서도 사용 가능(읽기, 쓰기)
            // MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
            // MODE_APPEND: 기존 preference에 신규로 추가
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key1", "Hello") // key - value 방식으로 데이터를 저장
            editor.putString("key2", "World") // key - value 방식으로 데이터를 저장
            editor.apply()
        }

        findViewById<TextView>(R.id.Read).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val valueOne = sharedPreferences.getString("key1", "Default1")
            val valueTwo = sharedPreferences.getString("key2", "Default2")
            Log.d("testt", valueOne!!)
            Log.d("testt", valueTwo!!)
        }

        findViewById<TextView>(R.id.Update).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            // 기존에 사용했던 키와 동일한 키를 사용해서 데이터를 저장
            editor.putString("key1", "Hello World")
            editor.apply()
        }

        findViewById<TextView>(R.id.Delete).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            // "table_name" 으로 되어 저장되어 있는 데이터들 삭제
            editor.clear()
            editor.apply()
        }
    }
}