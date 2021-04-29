package com.example.test

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_risk_list.*

class RiskListActivity : AppCompatActivity() {

    val profileItemList : ArrayList<Profile_Item> = ArrayList()
    lateinit var profileRecyclerView : RecyclerView
    var mAdapter = ProfileRecyclerViewAdapter(this, profileItemList)
    val spinnerItems = arrayOf("Storm","Fire","Flood","Drought","User Defiend")


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
        profileRecyclerView.addItemDecoration(HorizontalItemDecorater(dpToPx(this, 16)))
        profileRecyclerView.adapter = mAdapter

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        select_type_risk_spinner.adapter = spinnerAdapter
    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
                .toInt()
        return px
    }

}

class HorizontalItemDecorater(private val divHeight : Int) : RecyclerView.ItemDecoration() {
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = divHeight
        outRect.left = divHeight
    }
}