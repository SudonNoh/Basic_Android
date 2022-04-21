package com.example.fastcampus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class RecycleViewHomework : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_homework)

        // 객체 생성
        val talkList = mutableListOf<TalkContent>()
        val random = Random
        val ids = mutableListOf<String>("감자", "고구마")
        val contents =
            mutableListOf<String>("오늘 날씨가 좋네", "오늘 밤에는 비가 올거야", "화장실이 가고 싶다", "웃긴 얘기야", "ㅋㅋㅋㅋㅋㅋ")
        for (i in 0..100) {
            val profileId = ids[random.nextInt(2)]
            val contentsText = contents[random.nextInt(5)]
            talkList.add(TalkContent(profileId, contentsText))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.talkWindow)
        recyclerView.adapter = TalkViewAdapter(talkList, LayoutInflater.from(this), this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class TalkContent(
    val profileId: String,
    val talk: String
)

class TalkViewAdapter(
    val talkList: MutableList<TalkContent>,
    val inflater: LayoutInflater,
    val context: Context
) : RecyclerView.Adapter<TalkViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView
        val profileId: TextView
        val talk: TextView

        init {
            profileImage = itemView.findViewById(R.id.profileImage)
            profileId = itemView.findViewById(R.id.profileId)
            talk = itemView.findViewById(R.id.talk)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (talkList[position].profileId == "감자") 1 else 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TalkViewAdapter.ViewHolder {
        val view = when (viewType) {
            1 -> inflater.inflate(R.layout.talk_one, parent, false)
            2 -> inflater.inflate(R.layout.talk_two, parent, false)
            else -> inflater.inflate(R.layout.talk_one, parent, false)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TalkViewAdapter.ViewHolder, position: Int) {
        val image = if (talkList[position].profileId == "감자") context.resources.getDrawable(
            R.drawable.man1,
            context.theme
        ) else context.resources.getDrawable(
            R.drawable.man2,
            context.theme
        )

        holder.profileImage.setImageDrawable(
            image
        )
        holder.profileId.text = talkList[position].profileId
        holder.talk.text = talkList[position].talk
    }

    override fun getItemCount(): Int {
        return talkList.size
    }
}