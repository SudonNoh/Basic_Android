package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
// NetworkOnMainThreadException : main thread 에서 네트워크 작업하면 안된다는 경고
//     -  Network 작업은 따로 Thread 를 만들어서 해야 한다.
class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        // 요청부
        val urlString : String = "http://mellowcode.org/json/students/"
        val url : URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        // Header 부분
        connection.setRequestProperty("Content-Type", "application/json")

        // 응답부
        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            // 응답을 읽어서 반환하는데 읽는 대로 반환하는 것이 아니라 읽었던 부분을 어느 정도
            // 모았다가 반환
            val reader = BufferedReader(
                // 응답을 변환
                InputStreamReader(
                    // connection.inputStream : 응답이 들어있는 부분(컴퓨터 언어로)
                    connection.inputStream,
                    // 사람이 알 수 있는 언어셋로 읽기
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }
    }
}