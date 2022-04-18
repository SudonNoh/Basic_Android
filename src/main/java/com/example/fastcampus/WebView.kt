package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val btn: Button = findViewById(R.id.webView_btn)
        val editTextLine: EditText = findViewById(R.id.editText)

        val urlPrefix: String = "http://"


        // 2번 방법
        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                // return true 같은 경우에는 우리 앱이 주도권을 가져오지 않겠다는 의미
                // return false 의 경우에는 우리 앱이 주도권을 가져오겠다는 의미
                return false
            }
        })

        try {
            myWebView.loadUrl(intent.data!!.toString())
        } catch (exception: Exception) {

        }

        // addTextChangedListener 사용법 : 람다형식
        editTextLine.doBeforeTextChanged { text, start, count, after -> }
        editTextLine.doOnTextChanged { text, start, before, count -> }
        editTextLine.doAfterTextChanged { }

        // 1번 방법
        // myWebView.webViewClient = WebViewClient()
        //
        // btn.setOnClickListener {
        //     Log.d("btn_edit", editTextLine.text.toString())
        //     myWebView.loadUrl(urlPrefix + editTextLine.text.toString())
        // }

        // 2번 방법
        // manifest에 intent 부분에
        // <action android:name="android.intent.action.VIEW" />
        // <category android:name="android.intent.category.DEFAULT" />
        // <category android:name="android.intent.category.BROWSABLE" /> 추가
        // <data
        //     android:host="*"
        //     android:scheme="http" />
        // data의 host 부분은 접근할 수 있는 url 을 지정해 두는 것으로 브라우저를 새로 오픈하는 것이 아닌
        // 우리 앱 내에서 접근하는 경우 이 부분을 설정하면 지정 url만 오픈이 가능하도록 할 수 있다.
        // ex) android:host="naver.com" 만약 Google.com으로 하면 chrome 과 같은 브라우저로 오픈해야 한다.
        // scheme는 data의 type을 지정한다. 여기서 http는 http type만을 받고, 어떤 경우에는 file 등의 형태로
        // 받는다.
        btn.setOnClickListener {
            val url = urlPrefix + editTextLine.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}