package com.example.fastcampus

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        findViewById<TextView>(R.id.askPermission).setOnClickListener {
            // 권한이 없을 때만 물어야 한다.
            // 권한이 있는지 없는 지 알아야 한다.
            val cameraPermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            )

            if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                // requestCode : 요청을 구분하기 위한 숫자
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                Log.d("student", "카메라 권한 있음")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            // 우리 보낸 요청이 맞다면
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("student", "승낙")
            } else {
                Log.d("student", "거절")
            }
        }
    }
}