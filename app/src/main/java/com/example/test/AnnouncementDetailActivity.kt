package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_announcement_detail.*

class AnnouncementDetailActivity : AppCompatActivity() {
    // 공지사항 리스트에서 아이템 눌렀을때 표시해줄 액티비티
    var getDate : String = ""
    var getTitle : String = ""
    var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement_detail)

        getDate = intent.getStringExtra("date")!!
        getTitle = intent.getStringExtra("title")!!
        position = intent.getIntExtra("position", 0)

        announcement_detail_date.text = getDate
        announcement_detail_name.text = getTitle
    }

    fun announcementDetailBack(view: View) {
        finish()
    }
}