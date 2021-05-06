package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_alarm_history.*
import kotlinx.android.synthetic.main.activity_medical_detail.view.*
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.*
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.view.*

class RiskInfoAndWeatherActivity : AppCompatActivity() {
    lateinit var noticeOn : ImageView

    var mDrawer : DrawerLayout? = null

    private val adapter by lazy{RiskInfoAndWeatherAdapter(supportFragmentManager)}
    private val adapter2 by lazy{AlarmHistoryAdapter(supportFragmentManager)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_info_and_weather)

        noticeOn = notice_on
        mDrawer = drawer

        view_pager.adapter = RiskInfoAndWeatherActivity@adapter
        top_tab.setupWithViewPager(view_pager)


        alarm_view_pager.adapter = AlarmHistoryActivity@adapter2
        alarm_tab.setupWithViewPager(alarm_view_pager)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

        })
    }

    fun loudClick(view: View) {
        Toast.makeText(view.context, "notice Clicked", Toast.LENGTH_SHORT).show()
    }
    fun noticeClick(view: View) {
        if(!mDrawer!!.isDrawerOpen(Gravity.LEFT)){
            mDrawer!!.openDrawer(Gravity.LEFT)
        }
    }

}