package com.example.fastcampus

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//class StudentFromServer(
//    val id: Int,
//    val name: String,
//    val age: Int,
//    val intro: String
//)

// id 받지 않도록
class StudentFromServer(
    val id: Int,
    val name: String,
    val age: Int,
    val intro: String
) {
    constructor(name: String, age: Int, intro: String) : this(0, name, age, intro)
}

// 주로 Service 라고 명명을 함
// Service 는 interface 로
// Retrofit 으로 많은 API에 요청을 보낼 것, 이때마다 받아올 객체는 모두 다름
// 내가 요청한 것에 대해서 어떤 응답(타입, 객체)이 오는지에 대해 정해주는 것
interface RetrofitService {
    @GET("json/students")
    // 아래 함수를 쓰면 위에 있는 주소로 요청이 간다.
    fun getStudentList(): Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    // HashMap : 사람이 읽을 수 없는 Key-Value 형식으로 암호화
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<StudentFromServer>

    @POST("json/students/")
    fun easyCreateStudent(
        @Body student: StudentFromServer
    ): Call<StudentFromServer>
}