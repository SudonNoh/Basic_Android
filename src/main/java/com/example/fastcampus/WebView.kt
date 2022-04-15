package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // 1. 버튼을 누르기
        val btn: Button = findViewById(R.id.webView_btn)
        val editTextLine: EditText = findViewById(R.id.editText)
        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.webViewClient = WebViewClient()


        btn.setOnClickListener {
            // 2. EditText 에서 URL 가져오기
            Log.d("btn_edit", editTextLine.text.toString())
            //  myWebView.loadUrl("https://" + editTextLine.text.toString())
        }


        // 3. URL 을 실행하기기
    }
}