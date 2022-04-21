package com.example.fastcampus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // 데이터 준비
        var carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car(nthCar = "" + i + "번째 자동차", nthEngine = "" + i + "번째 엔진"))
        }
        val adapter = ListViewAdapter(
            carList,
            LayoutInflater.from(this),
            this
        )

        // 어답터 장착 방법
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        // 리스너 장착 방법
        // parent : item이 붙어있는 부모 view
        // view : item 하나
        // position : 몇 번째 item인지
        // id : getItemId 에서 return 해주었던 id가 온다.
        listView.setOnItemClickListener { parent, view, position, id ->
            val car: Car = adapter.carList[position]
            val nthCar = car.nthCar
            val nthEngine = car.nthEngine

            Toast.makeText(
                this,
                nthCar + "  " + nthEngine,
                Toast.LENGTH_LONG
            ).show()
        }

        // 데이터 갱신 방법
        findViewById<TextView>(R.id.addCar).setOnClickListener {
            adapter.carList.add(
                Car("안녕 나는 차", "안녕 나는 엔진")
            )
            adapter.notifyDataSetChanged()
        }
    }
}

class ListViewAdapter(
    val carList: MutableList<Car>,
    val layoutInflater: LayoutInflater,
    val context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        // 전체 데이터의 크기(개수)를 반환
        return carList.size
    }

    override fun getItem(position: Int): Any {
        // 전체 데이터 중에서 해당 번째(position)의 데이터를 반환
        return carList[position]
    }

    override fun getItemId(position: Int): Long {
        // 잘 사용하지 않고 들어온 position의 타입을 long으로 반환
        return position.toLong()
    }

    // convertView : 재활용되는 view
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            // 최초 실행될 때
            view = layoutInflater.inflate(R.layout.car_item, null)
            holder = ViewHolder()
            holder.carImage?.setImageDrawable(
                context.resources.getDrawable(R.drawable.download, context.theme)
            )
            holder.carImage = view.findViewById<ImageView>(R.id.carImage)
            holder.nthCar = view.findViewById<TextView>(R.id.nthCar)
            holder.nthEngine = view.findViewById<TextView>(R.id.nthEngine)
            // tag라는 속성을 만들어서 holder를 저장
            view.tag = holder
        } else {
            // 재활용 가능
            // holder를 들어온 convertView로 재정의
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        val car = carList[position]
        holder.carImage?.setImageDrawable(
            context.resources.getDrawable(R.drawable.download, context.theme)
        )
        holder.nthCar?.text = car.nthCar
        holder.nthEngine?.text = car.nthEngine
        // 해당 번째 뷰를 반환
//        val view = layoutInflater.inflate(R.layout.car_item, null)
//        val carImage = view.findViewById<ImageView>(R.id.carImage)
//        val nthCar = view.findViewById<TextView>(R.id.nthCar)
//        val nthEngine = view.findViewById<TextView>(R.id.nthEngine)
//
//        val car = carList[position]
//        carImage.setImageDrawable(
//            context.resources.getDrawable(R.drawable.download, context.theme)
//        )
//        nthCar.text = car.nthCar
//        nthEngine.text = car.nthEngine
        return view
    }
}

class ViewHolder {
    var carImage: ImageView? = null
    var nthCar: TextView? = null
    var nthEngine: TextView? = null
}