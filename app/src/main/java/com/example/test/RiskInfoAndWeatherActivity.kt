package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_risk_info_and_weather.*

class RiskInfoAndWeatherActivity : AppCompatActivity() {

    private val adapter by lazy{RiskInfoAndWeatherAdapter(supportFragmentManager)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_info_and_weather)

        viewpager.adapter = RiskInfoAndWeatherActivity@adapter
        top_tab.setupWithViewPager(viewpager)
    }

    fun loudClick(view: View) {
        Toast.makeText(view.context, "notice Clicked", Toast.LENGTH_SHORT).show()
    }
    fun noticeClick(view: View) {
        Toast.makeText(view.context, "loud Clicked", Toast.LENGTH_SHORT).show()
    }

}