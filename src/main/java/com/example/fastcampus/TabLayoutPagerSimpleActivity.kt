package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabLayoutPagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_pager_simple)

        val viewPager = findViewById<ViewPager>(R.id.pager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        // tabLayout 에 Tab 을 추가하는 방법
        tabLayout.addTab(tabLayout.newTab().setText("1번"))
        tabLayout.addTab(tabLayout.newTab().setText("2번"))
        tabLayout.addTab(tabLayout.newTab().setText("3번"))

        viewPager.adapter = ViewPagerAdapter(LayoutInflater.from(this), 3)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}

// fragment 를 쓰지 않고 간단히 사진만 입력하는 경우
class ViewPagerAdapter(
    val layoutInflater: LayoutInflater,
    val tabCount: Int
) : PagerAdapter() {
    override fun getCount(): Int {
        return tabCount
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
        // == -> 값을 비교
        // === -> 주소값을 비교
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.activity_one, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.activity_two, container, false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.activity_three, container, false)
                container.addView(view)
                return view
            }
        }
    }
}