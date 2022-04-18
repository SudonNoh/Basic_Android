package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager = supportFragmentManager
        val fragmentFirst = FragmentFirst()

        // Transaction
        //    - 작업의 단위: 시작과 끝이 있다.
        //    - 끝이 정해져야 transaction이 실행된다.
        //    - 끝이 정해지지 않으면 시작되지 않는다.
        (findViewById<TextView>(R.id.add)).setOnClickListener {
            // Transaction의 시작
            val transaction = fragmentManager.beginTransaction()
            // fragment에 데이터를 전달하는 방법
            val bundle = Bundle()
            bundle.putString("key", "HELLO")
            // 여기서 fragmentFirst는 위에 있는 val fragmentFirst
            fragmentFirst.arguments = bundle
            // transaction.A
            // transaction.B
            // transaction.C
            // transaction.replace(R.id.root, fragmentFirst)

            // xml에 없어 id가 없는 경우에는 tag를 달아서 구분해준다.
            transaction.replace(R.id.root, fragmentFirst, "fragment_first_tag")
            // transaction 끝 !!
            transaction.commit()
            // Commit
            // 1) commit
            // 2) commitAllowingStateLoss
            // 3) commitNow
            // 3) commitNowAllowingStateLoss

            // commit - commitAllowingStateLoss(AllowingStateLoss
            //    - 상태저장 -> onSaveInstanceState (워드에서 저장하기를 눌렀을 때와 유사)
            //    - commit : 저장을 한 경우 실행 할 수 없다(IllegalStateException 발생)
            //    - commitAllowingStateLoss : 저장을 한 경우 예외가 발생하지 않고 그냥 손실
            //                                이후에 생긴 로그(추가/제거)를 무시하고 진행
            // commit - commitNow(Now)
            //    - commit -> 작업을 예약한다 (main Thread에 예약이 된다)
            //    - commitNow -> 바로 실행해!
        }

        (findViewById<TextView>(R.id.remove)).setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()
        }

        (findViewById<TextView>(R.id.access_fragment)).setOnClickListener {
            // xml에서 fragment를 찾는 방법
            val fragmentFirstOne =
                supportFragmentManager.findFragmentById(R.id.fragment_first) as FragmentFirst

            fragmentFirstOne.printTestLog()
            // xml에 없는 fragment를 찾는 방법
            val fragmentFirstTwo = supportFragmentManager.findFragmentByTag("fragment_first_tag") as FragmentFirst
            fragmentFirstTwo.printTestLog()
        }
    }

    fun printTestLog() {
        Log.d("testt", "print test log from activity")
    }
}