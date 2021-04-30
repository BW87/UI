package com.example.test

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_risk_list.*
import kotlinx.android.synthetic.main.activity_risk_list.view.*

class RiskListActivity : AppCompatActivity() {

    val profileItemList : ArrayList<Profile_Item> = ArrayList()
    val riskListItemList : ArrayList<Risk_List_Item> = ArrayList()
    lateinit var profileRecyclerView : RecyclerView
    lateinit var riskListRecyclerView : RecyclerView
    var rAdapter = RiskListRecyclerViewAdapter(this, riskListItemList)
    var mAdapter = ProfileRecyclerViewAdapter(this, profileItemList)
    val spinnerItemsData = arrayOf("Storm","Fire","Flood","Drought","User Defined")

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

        profileRecyclerView.addItemDecoration(HorizontalItemDecorator(dpToPx(this, 16)))
        profileRecyclerView.adapter = mAdapter


        val spinnerAdapter = object : ArrayAdapter<String>(this, R.layout.spinner_item) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)

                if(position == count){

                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).text = ""
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).hint = getItem(count)

                }



                if(position == select_type_risk_spinner.selectedItemPosition){
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).setTextColor(
                        ContextCompat.getColor(context, R.color.white))
                }

                return v
            }

            override fun getCount(): Int {
                return super.getCount()-1
            }
        }

        spinnerAdapter.addAll(spinnerItemsData.toMutableList())
        spinnerAdapter.add("Search by type of risk")

        select_type_risk_spinner.adapter = spinnerAdapter
        select_type_risk_spinner.setSelection(spinnerAdapter.count)

        riskListItemList.add(Risk_List_Item("Storm", "8 m ago", "0.68km", "change_storm_img"))
        riskListItemList.add(Risk_List_Item("Fire", "9 m ago", "0.91km", "change_fire_img"))
        riskListItemList.add(Risk_List_Item("Flood", "15 m ago", "1.17km", "change_flood_img"))
        riskListItemList.add(Risk_List_Item("Drought", "19 m ago", "1.84km", "change_drought_img"))
        riskListItemList.add(Risk_List_Item("User Defined", "26 m ago", "2.03km", "change_user_defined_img"))

        riskListRecyclerView = risk_list_recyclerview
        riskListRecyclerView.addItemDecoration(CustomItemDecorator(dpToPx(this, 16)))
        riskListRecyclerView.layoutManager = LinearLayoutManager(this)
        riskListRecyclerView.adapter = rAdapter

    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
                .toInt()
        return px
    }


}

class HorizontalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = divHeight
        outRect.left = divHeight
    }
}

class CustomItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = divHeight
    }
}