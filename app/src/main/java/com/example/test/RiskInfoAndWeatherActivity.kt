package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_alarm_history.*
import kotlinx.android.synthetic.main.activity_medical_detail.view.*
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.*
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.view.*

class RiskInfoAndWeatherActivity : AppCompatActivity() {
    lateinit var noticeOn : ImageView

    var slidingClose : ImageButton? = null
    var mDrawer : DrawerLayout? = null

    private val adapter by lazy{RiskInfoAndWeatherAdapter(supportFragmentManager)}
    private val adapter2 by lazy{AlarmHistoryAdapter(supportFragmentManager)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_info_and_weather)

        noticeOn = notice_on
        mDrawer = drawer
        slidingClose = alarm_history_close

        mDrawer!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
        mDrawer!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        slidingClose!!.setOnClickListener {
            if(mDrawer!!.isDrawerOpen(Gravity.LEFT)){
                mDrawer!!.closeDrawer(Gravity.LEFT)
            }
        }

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

        bottom_tab.setOnNavigationItemSelectedListener{
           when(it.itemId){
               R.id.main -> {
                   true
               }

               R.id.riskList -> {
                   val intent = Intent(this, RiskListActivity::class.java)
                   startActivity(intent)
                   finish()
                   true
               }

               R.id.medicalAid -> {
                   val intent = Intent(this, MedicalActivity::class.java)
                   startActivity(intent)
                   finish()

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

    fun loudClick(view: View) {
        Toast.makeText(view.context, "notice Clicked", Toast.LENGTH_SHORT).show()
    }
    fun noticeClick(view: View) {
        if(!mDrawer!!.isDrawerOpen(Gravity.LEFT)){
            mDrawer!!.openDrawer(Gravity.LEFT)
        }
    }

}