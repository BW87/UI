package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_risk_list.*

class RiskListActivity : AppCompatActivity() {

    val profileItemList : ArrayList<Profile_Item> = ArrayList()
    lateinit var profileRecyclerView : RecyclerView
    var mAdapter = ProfileRecyclerViewAdapter(this, profileItemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_list)

        profileItemList.add(Profile_Item("서보원", "경기도 성남시 분당구 삼평동 514-132"))
        profileItemList.add(Profile_Item("서보현", "대구광역시 달서구 월성동 서한 이다음 아파트"))
        profileItemList.add(Profile_Item("서보연", "경기도 성남시 분당구 정자동 58-4"))

        profileRecyclerView = profile_recyclerview
        profileRecyclerView.layoutManager = LinearLayoutManager(this).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
        profileRecyclerView.adapter = mAdapter

    }
}