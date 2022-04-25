package com.example.fastcampus

import retrofit2.Call
import retrofit2.http.GET

class StudentFromServer(
    val id : Int,
    val name : String,
    val age : Int,
    val intro : String
)

// Retrofit 으로 요청할 때마다 받는 응답이 다르다.
// 내가 요청한 것에 대해서 어떤 응답이 오는지에 대해 정해주는 것
interface RetrofitService {
    @GET("json/students")
    fun getStudentList():Call<ArrayList<StudentFromServer>>
}