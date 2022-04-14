package com.example.fastcampus

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class Intent_One : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        // 암시적 인텐트
        // - 전화, SMS, Google Play Store, Website, GoogleMap, 사진첩 ...
        // R: Resource
        // - 상수
        //    - 변하지 않는 수(문자)
        //    - 상수의 변수명은 전부 대문자로 만드는 문화가 있다
        // - URI (Uniform Resource Identifier)
        //    - ID 라고 생각을 하면 된다(고유값)
        //    - 자원을 나타내는 고유한 주소
        //    - URL
        //        - 인터넷 페이지의 고유한 주소
        val implicit_intent: TextView = findViewById(R.id.implicit_intent)
        implicit_intent.setOnClickListener {
            val intent: Intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:" + "010-1111-1111")
            )
            // intent를 실행
            startActivity(intent)
        }

        // 명시적 인텐트 + ComponentName -> 액티비티 전환
        // 화면 전환할 때
        val intent_one: TextView = findViewById(R.id.intent_one)
        intent_one.setOnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName = ComponentName(
                "com.example.fastcampus",
                "com.example.fastcampus.Intent_Two"
            )
            intent.component = componentName
            startActivity(intent)
        }

        // 명시적 인텐트 context -> 액티비티 전환
        (findViewById<TextView>(R.id.intent_two)).apply {
            this.setOnClickListener {
                // 시작점: this@Intent_One / 목적지: Intent_Two::class.java
                startActivity(
                    Intent(this@Intent_One, Intent_Two::class.java)
                )
            }
        }

        // 명시적 인텐트 + data 전달
        (findViewById<TextView>(R.id.intent_three)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                intent.putExtra("extra-data", "data-one이 넘어간다 ~~")
                startActivity(intent)
            }
        }

        // 명시적 인텐트 + 결과 받기 ( ActivityResult API)
        //    -> requestCode가 존재하지 않음
        //    -> requestCode 없이도 요청자를 구분할 수 있다
        val startActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            when(it.resultCode){
                RESULT_OK->{
                    Log.d("dataa", it.data?.extras?.getString("result")!!)

                }
            }
            // ActivityResult API 의 경우 각각의 intent가 처리되는 곳이 별도로 있다.-> 구분이 필요 없다.
        }

        val startActivityLauncher2: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            when(it.resultCode){
                RESULT_OK->{
                    Log.d("data", it.data?.extras?.getString("result")!!)
                }
            }
            // ActivityResult API 의 경우 각각의 intent가 처리되는 곳이 별도로 있다.-> 구분이 필요 없다.
        }


        (findViewById<TextView>(R.id.intent_five)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                startActivityLauncher.launch(intent)
            }
        }

    }
}