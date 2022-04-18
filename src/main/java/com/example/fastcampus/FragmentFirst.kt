package com.example.fastcampus

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class FragmentFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : 우리가 작성한 xml을 사용자 눈에 보일 수 있게 준비를 시켜놓는 것(XML을 View로 만들어 준다)
        // container : Fragment에서 사용 될 xml의 부모뷰
        // savedInstanceState : 사용한 기록이 남아 있음
        // return inflater.inflate(R.layout.first_fragment, container, false)

        // onCreateview에서 onClickListner를 실행, Activity의 경우
        // onCreate에서 setContentView(R.layout.activity_fragment)를 실행한다.
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        // attachToRoot : RootView에 fragment를 붙여주는데, 언제 붙는지 결정
        var count: Int = 0

        // 아래와 같이 Activity에 접근할 일이 있으면 onActivityCreated()에서 접근하는 것이 좋다고 한다.
        // 아래는 예시를 보여준 것일일 뿐이다.
       (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener {
            // activity 가져오기 FragmentActivity로 casting
            (activity as FragmentActivity).printTestLog()
            val changeText: TextView = view.findViewById<TextView>(R.id.call_activity)
            count += 1
            changeText.text = count.toString()
            if (count % 2 == 0) {
                changeText.setBackgroundColor(Color.GREEN)
                changeText.setTextColor(Color.BLACK)
            } else {
                changeText.setTextColor(
                    ContextCompat.getColor(
                        requireActivity().applicationContext,
                        R.color.white
                    )
                )
                changeText.setBackgroundColor(
                    ContextCompat.getColor(
                        requireActivity().applicationContext,
                        R.color.lightPurple
                    )
                )
            }

        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: String? = arguments?.getString("key")
        Log.d("testt", "data is $data")
    }

    fun printTestLog() {
        Log.d("testt", "print test log !!!! from fragment")
    }
}