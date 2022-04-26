package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        // get
        retrofitService.getStudentList().enqueue(object : Callback<ArrayList<StudentFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<StudentFromServer>>,
                response: Response<ArrayList<StudentFromServer>>
            ) {
                if (response.isSuccessful) {
                    val studentList = response.body()
                    findViewById<RecyclerView>(R.id.studentsRecyclerView).apply {
                        this.adapter = StudentListRecyclerViewAdapter(
                            studentList!!,
                            LayoutInflater.from(this@RetrofitActivity)
                        )
                        this.layoutManager = LinearLayoutManager(this@RetrofitActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<StudentFromServer>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        // post
        findViewById<TextView>(R.id.createStudent).setOnClickListener {
            val student = HashMap<String, Any>()
            student["name"] = "칼로바이 탄산"
            student["intro"] = "펩시"
            student["age"] = 100
            retrofitService.createStudent(student).enqueue(object : Callback<StudentFromServer> {
                override fun onResponse(
                    call: Call<StudentFromServer>,
                    response: Response<StudentFromServer>
                ) {
                    if (response.isSuccessful) {
                        val studentBody = response.body()
                        Log.d("student", "등록한 학생 : ${studentBody!!.name}")
                    }
                }

                override fun onFailure(call: Call<StudentFromServer>, t: Throwable) {
                    Log.d("student", "요청 실패")
                }
            })
        }

        // Hash 를 쓰지 않고 한번에 객체를 입력
        findViewById<TextView>(R.id.easyCreateStudent).setOnClickListener {
            val student = StudentFromServer(name = "베스킨라빈스", age = 200, intro = "welcome to 31")
            retrofitService.easyCreateStudent(student).enqueue(object: Callback<StudentFromServer>{
                override fun onResponse(
                    call: Call<StudentFromServer>,
                    response: Response<StudentFromServer>
                ) {
                    if (response.isSuccessful) {
                        val studentBody = response.body()
                        Log.d("student", "등록한 학생 : ${studentBody!!.name}")
                    }
                }

                override fun onFailure(call: Call<StudentFromServer>, t: Throwable) {
                    Log.d("student", "요청 실패")
                }
            })
        }
    }
}

class StudentListRecyclerViewAdapter(
    var studentList: ArrayList<StudentFromServer>,
    var inflater: LayoutInflater
) : RecyclerView.Adapter<StudentListRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView
        val studentAge: TextView
        val studentIntro: TextView

        init {
            studentName = itemView.findViewById(R.id.student_name)
            studentAge = itemView.findViewById(R.id.student_age)
            studentIntro = itemView.findViewById(R.id.student_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.studentName.text = studentList[position].name
        holder.studentAge.text = studentList[position].age.toString()
        holder.studentIntro.text = studentList[position].intro
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}