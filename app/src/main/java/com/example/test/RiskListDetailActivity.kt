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
    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
                .toInt()
        return px
    }
}

