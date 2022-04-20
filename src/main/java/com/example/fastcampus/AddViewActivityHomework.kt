package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import org.w3c.dom.Text

class AddViewActivityHomework : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view_homework)

        var blogList = mutableListOf<Blog>()
        for (i in 1..30) {
            blogList.add(Blog(blogName = "블로그 이름: $i", blogNumber = "블로그 번호: $i"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.homeworkContainer)
        val inflater = LayoutInflater.from(this@AddViewActivityHomework)

        blogList.forEach { Blog ->
            val addViewItemView = inflater.inflate(R.layout.activity_add_view_item, null)
            val blogImage = addViewItemView.findViewById<ImageView>(R.id.blogImage)
            val blogName = addViewItemView.findViewById<TextView>(R.id.blogName)
            val blogNumber = addViewItemView.findViewById<TextView>(R.id.blogNumber)

            blogImage.setImageDrawable(resources.getDrawable(R.drawable.download, this.theme))
            blogName.text = Blog.blogName
            blogNumber.text = Blog.blogNumber

            addViewItemView.setOnClickListener {
                val intent: Intent =
                    Intent(this@AddViewActivityHomework, AddViewActivityHomework2::class.java)
                intent.putExtra("blogName", Blog.blogName)
                intent.putExtra("blogNumber",Blog.blogNumber)
                startActivity(intent)
            }
            container.addView(addViewItemView)
        }
    }
}

class Blog(val blogName: String, val blogNumber: String)