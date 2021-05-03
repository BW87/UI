package com.example.test

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_risk_list_detail.*

class RiskListDetailActivity : AppCompatActivity() {

    val photoItemList = ArrayList<Photo_Item>()
    lateinit var photoRecyclerView : RecyclerView
    val photoAdapter = PhotoRecyclerViewAdapter(this, photoItemList)

    val commentItemList = ArrayList<Comment_Item>()
    lateinit var commentRecyclerView : RecyclerView
    val commentAdapter = CommentsRecyclerViewAdapter(this, commentItemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_list_detail)

        risk_list_detail_risk_type.text = intent.getStringExtra("riskType")
        risk_list_detail_elapsed_time_value.text = intent.getStringExtra("riskElapsed")
        risk_list_detail_distance_value.text = intent.getStringExtra("riskDistance")

        photoItemList.add(Photo_Item("circle"))
        photoItemList.add(Photo_Item("circle"))
        photoItemList.add(Photo_Item("circle"))

        photoRecyclerView = photo_recyclerview
        photoRecyclerView.layoutManager = LinearLayoutManager(this).also{
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
        photoRecyclerView.addItemDecoration(HorizontalItemDecorator(dpToPx(this, 16)))
        photoRecyclerView.adapter = photoAdapter

        commentItemList.add(Comment_Item("홍길동", "여러분, 이번 태풍은 정말 심각합니다. 점점 더 비바람이 세지고 있어요! 모두 대피하세요", "16s ago"))
        commentItemList.add(Comment_Item("서보원", "신촌동 주민센터 근처에 계신분들 강풍 및 비바람 조심하세요!", "5m 16s ago"))
        commentItemList.add(Comment_Item("서보연", "여러분, 이번 태풍은 정말 심각합니다. 점점 더 비바람이 세지고 있어요! 모두 대피하세요", "6m 16s ago"))

        commentRecyclerView = comment_recyclerview
        commentRecyclerView.layoutManager = LinearLayoutManager(this)
        commentRecyclerView.addItemDecoration(VerticalItemDecorator(dpToPx(this, 16)))
        commentRecyclerView.adapter = commentAdapter

    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
                .toInt()
        return px
    }
}

