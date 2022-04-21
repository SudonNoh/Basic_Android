package com.example.fastcampus

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // 객체 생성
        val carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car("$i 번째 자동차", "$i 번째 엔진"))
        }
        // adapter 장착
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this), this)
        // 방향설정
         recyclerView.layoutManager = LinearLayoutManager(this)
        // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        // recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}

// Recycler View 의 Adapter 를 만들 때는 ViewHolder 를 블럭 안에(inner class) 만든다.
// outer class
class RecyclerViewAdapter(
    val carList: MutableList<Car>,
    val inflater: LayoutInflater,
    val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    // inner class
    // ViewHolder는 itemView의 상세 View Component 를 홀드한다.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // RecyclerView.ViewHolder(itemView) : 개선된 View holder를 사용하기 위해 상속 받음.
        // init 에서 먼저 view component를 찾아준다.
        val carImage: ImageView
        val nthCar: TextView
        val nthEngine: TextView

        init {
            carImage = itemView.findViewById(R.id.carImage)
            nthCar = itemView.findViewById(R.id.nthCar)
            nthEngine = itemView.findViewById(R.id.nthEngine)
            // RecyclerView 에서는 setOnClickListener 를 기본적으로 제공해주지 않는다.
            // setOnClickListener 를 사용하는 기본적인 위치는 Holder 의 init 블록이고,
            // 추후에 interface 로 받아서 사용하거나 파라미터로 받아서 사용하는 것은 가능하다.
            // 이미 itemView 이기 때문에 setOnClickListener 로 사용한다.
            itemView.setOnClickListener {
                // adapterPosition 은 RecyclerView 가 제공하는 변수로
                // 지금 만드는 setOnClickListener 가 몇번째 리스너인지 구분 할 수 있도록 해준다.
                val position : Int = adapterPosition
                // INNER CLASS 에서는 OUTER CLASS 에 존재하는 변수에 접근할 수 있는데,
                // class 안에 class 를 작성한다고 inner class 가 되는 것은 아니다.
                // class 앞에 inner 를 붙여 inner class 로 만들어준다.
                val car = carList[position]
                Log.d("testt", car.nthCar)
            }
        }
    }

    // item View 를 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // holder 를 만들어 준다
        // car_item 의 XML 코드를 view 로 불러온다
        // parent 는 ViewHolder 가 사용되는 View
        // attachToRoot : 지금 만드는 view 를 parent 의 자식으로 붙일거냐는 의미
        val view = inflater.inflate(R.layout.car_item, parent, false)
        // inner 를 class 앞에 붙여준 다음에는 아래와 같은 방법으로 접근이 불가능하다.
        // return RecyclerViewAdapter.ViewHolder(view)
        return ViewHolder(view)

    }

    // 데이터를 itemView 의 component 와 묶는다.(View 를 채워준다)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carImage.setImageDrawable(
            context.resources.getDrawable(R.drawable.download, context.theme)
        )
        holder.nthCar.text = carList[position].nthCar
        holder.nthEngine.text = carList[position].nthEngine
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}