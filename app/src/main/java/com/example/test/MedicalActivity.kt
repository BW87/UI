package com.example.test

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_alarm_setting.view.*
import kotlinx.android.synthetic.main.activity_medical.*
import kotlinx.android.synthetic.main.aid_item.view.*

class MedicalActivity : AppCompatActivity() {
    // 근처 구호소를 보여주는 액티비티

    private val medicalItemData : ArrayList<Medical_Item> = ArrayList()
    private lateinit var medicalActivityRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical)

        medicalItemData.add(Medical_Item("Hospital", "일산병원", 1.4,0))
        medicalItemData.add(Medical_Item("Parmacy", "이화약국", 0.8,0))
        medicalItemData.add(Medical_Item("NGO","비정부기구", 2.0 ,0))
        medicalItemData.add(Medical_Item("Partnership", "서울대병원", 8.2,0))

        medicalActivityRecyclerView = aid_recyclerview
        medicalActivityRecyclerView.layoutManager = LinearLayoutManager(this).also{
            it.orientation = LinearLayoutManager.VERTICAL
        }

        val mAdapter = MedicalAidRecyclerViewAdapter(this, medicalItemData)
        medicalActivityRecyclerView.adapter = mAdapter
        medicalActivityRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(dpToPx(this,16)))

        bottom_tab.selectedItemId = R.id.medicalAid

        bottom_tab.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.main -> {
                    val intent = Intent(this, RiskInfoAndWeatherActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                R.id.riskList -> {
                    val intent = Intent(this, RiskListActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                R.id.medicalAid -> {

                    true
                }

                R.id.emergencyContact -> {
                    val intent = Intent(this, EmergencyContactActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.setting -> {
                    val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                    finish()

                    true
                }

                else -> false
            }
        }
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

