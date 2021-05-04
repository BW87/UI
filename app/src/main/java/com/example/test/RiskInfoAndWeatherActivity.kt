package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.*
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.view.*

class RiskInfoAndWeatherActivity : AppCompatActivity() {
    var notice : Boolean = false
    lateinit var noticeOn : ImageView

    private val adapter by lazy{RiskInfoAndWeatherAdapter(supportFragmentManager)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_info_and_weather)

        noticeOn = notice_on

        viewpager.adapter = RiskInfoAndWeatherActivity@adapter
        top_tab.setupWithViewPager(viewpager)

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

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
        if(!notice){
            noticeOn.visibility = View.VISIBLE
            notice = true
        } else {
            noticeOn.visibility = View.INVISIBLE
            notice = false
        }
    }

}