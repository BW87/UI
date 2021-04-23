package com.example.test

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_medical.*

class MedicalActivity : AppCompatActivity() {

    private val medicalItemData : ArrayList<Medical_Item> = ArrayList()
    private lateinit var medicalActivityRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical)

        medicalItemData.add(Medical_Item("Hospital", "일산병원", 1.4))
        medicalItemData.add(Medical_Item("Parmacy", "이화약국", 0.8))
        medicalItemData.add(Medical_Item("NGO","비정부기구", 2.0 ))
        medicalItemData.add(Medical_Item("Partnership", "서울대병원", 8.2))

        medicalActivityRecyclerView = aid_recyclerview
        medicalActivityRecyclerView.layoutManager = LinearLayoutManager(this).also{
            it.orientation = LinearLayoutManager.VERTICAL
        }

        medicalActivityRecyclerView.adapter = MedicalAidRecyclerViewAdapter(this,medicalItemData)
        medicalActivityRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(dpToPx(this,16)))
    }

    inner class VerticalSpaceItemDecoration(val verticalSpaceHeight : Int) : RecyclerView.ItemDecoration(){

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = verticalSpaceHeight
        }
    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
                .toInt()
        return px
    }

}

