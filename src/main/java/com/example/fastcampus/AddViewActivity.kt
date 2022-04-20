package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        var carList = mutableListOf<Car>()
        for (i in 0..30) {
            carList.add(Car(""+i+"번째 자동차", ""+i+"번째 엔진"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.container)
        // inflater : XML을 사용자의 눈에 보이게 코드상으로 가져온다.
        val inflater = LayoutInflater.from(this@AddViewActivity)
        carList.forEach {
            val carItemView = inflater.inflate(R.layout.car_item, null)
            // 여기서 carImage를 가져오려면 layout이 car_item 이어야 한다. 하지만
            // 지금 이 class 에서는 setContentView로 activity_add_view를 선택하고
            // 있기 때문에 inflater를 이용해서 car_item layout을 불러온다.
            val carImage = carItemView.findViewById<ImageView>(R.id.carImage)
            val nthCar = carItemView.findViewById<TextView>(R.id.nthCar)
            val nthEngine = carItemView.findViewById<TextView>(R.id.nthEngine)

            carImage.setImageDrawable(resources.getDrawable(R.drawable.download, this.theme))
            nthCar.text = it.nthCar
            nthEngine.text = it.nthEngine

            container.addView(carItemView)
        }



    }
}

class Car(val nthCar: String, val nthEngine: String)