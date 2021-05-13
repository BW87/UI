package com.example.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_announcement.*

class AnnouncementActivity : AppCompatActivity() {
    // 공지사항 보여주는 액티비티 위에 safety 교육으로 가는 버튼도 있음

    val announcementItemList : ArrayList<Announcement_Item> = ArrayList()
    lateinit var announcementRecyclerView : RecyclerView
    var mAdapter = AnnouncementRecyclerViewAdapter(this, announcementItemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)

        announcementItemList.add(Announcement_Item("2021.04.28", "RBG 어플 다운로드 1000만 돌파 기념 선물 증정 이벤트!!",1))
        announcementItemList.add(Announcement_Item("2021.04.27", "RBG APP 리뉴얼 안내",2))
        announcementItemList.add(Announcement_Item("2021.04.26", "RBG 어플 다운로드 100만 돌파!",3))
        announcementItemList.add(Announcement_Item("2021.04.25", "RBG APP 리뉴얼 중",4))
        announcementItemList.add(Announcement_Item("2021.04.24", "RBG 어플 다운로드 10만 돌파",5))
        announcementItemList.add(Announcement_Item("2021.03.23", "RBG 어플 업데이트 안내",6))
        announcementItemList.add(Announcement_Item("2021.03.01", "3.1절 고객세터 휴무 안내",7))

        announcementRecyclerView = announcement_recyclerview
        announcementRecyclerView.layoutManager = LinearLayoutManager(this)
      //  announcementRecyclerView.addItemDecoration(VerticalItemDecorator2(dpToPx(this, 16)))
        announcementRecyclerView.adapter = mAdapter

    }

    fun announcementBack(view: View) {
        finish()
    }

    fun goSafetyEduActivity(view: View) {
        startActivity(Intent(this, SafetyEduActivity::class.java))
    }
}