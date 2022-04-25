package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        // addConverterFactory : Serializer 라고 생각하면 될 듯
        // 서버 -> 읽을 수 없는 데이터 -> JSON -> GSON
        // GSON : 읽을 수 없는 데이터를 코틀린 객체로 바꿔준다.
        // builder 패턴 : builder 로 시작해 build 로 끝난다.
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)
        // enqueue : getStudentList() 를 실행하도록 하는 함수
        // Callback 함수 : 서버로부터 데이터를 요청, 응답을 받는 함수
        retrofitService.getStudentList().enqueue(object : Callback<ArrayList<StudentFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<StudentFromServer>>,
                response: Response<ArrayList<StudentFromServer>>
            ) {
                if (response.isSuccessful) {
                    val studentList = response.body()
                    studentList!!.forEach {
                        Log.d("testt", "${it.name}")
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<StudentFromServer>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}