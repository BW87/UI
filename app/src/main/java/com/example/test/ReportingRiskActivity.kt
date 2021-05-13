package com.example.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_alarm_setting.*
import kotlinx.android.synthetic.main.activity_reporting_risk.*

class ReportingRiskActivity : AppCompatActivity() {
    // 재난 신고 처음 부분 액티비티

    var stormButton : ImageButton? = null
    var fireButton : ImageButton? = null
    var floodButton : ImageButton? = null
    var droughtButton : ImageButton? = null
    var userButton : ImageButton? = null

    var stormImg : ImageView? = null
    var fireImg : ImageView? = null
    var floodImg : ImageView? = null
    var droughtImg : ImageView? = null
    var userImg : ImageView? = null

    val context : Context = this
    var riskType : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporting_risk)

        stormButton = choose_storm_button
        fireButton = choose_fire_button
        floodButton = choose_flood_button
        droughtButton = choose_drought_button
        userButton = choose_user_button

        stormImg = storm_off
        fireImg = fire_off
        floodImg = flood_off
        droughtImg = drought_off
        userImg = user_off

    }

    fun riskAllOff(){
        stormButton!!.setBackgroundResource(R.drawable.round_corner_dark)
        fireButton!!.setBackgroundResource(R.drawable.round_corner_dark)
        floodButton!!.setBackgroundResource(R.drawable.round_corner_dark)
        droughtButton!!.setBackgroundResource(R.drawable.round_corner_dark)
        userButton!!.setBackgroundResource(R.drawable.round_corner_dark)

        stormImg!!.setImageResource(R.drawable.ico_storm_off)
        fireImg!!.setImageResource(R.drawable.ico_fire_off)
        floodImg!!.setImageResource(R.drawable.ico_flood_off)
        droughtImg!!.setImageResource(R.drawable.ico_water_shortage_off)
        userImg!!.setImageResource(R.drawable.ico_user_defined_off)

    }

    fun goNext(view: View) {
        Intent(this, ReportingRiskNextActivity::class.java).apply{}.run{
            putExtra("riskType", riskType)
            startActivity(this)
        }
        finish()
    }

    fun clickStorm(view: View) {
        riskAllOff()
        stormButton!!.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
        stormImg!!.setImageResource(R.drawable.ico_storm_on)
        riskType = "Storm"
    }
    fun clickFlood(view: View) {
        riskAllOff()
        floodButton!!.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
        floodImg!!.setImageResource(R.drawable.ico_flood_on)
        riskType = "Flood"
    }
    fun clickFire(view: View) {
        riskAllOff()
        fireButton!!.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
        fireImg!!.setImageResource(R.drawable.ico_fire_on)
        riskType = "Fire"
    }
    fun clickDrought(view: View) {
        riskAllOff()
        droughtButton!!.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
        droughtImg!!.setImageResource(R.drawable.ico_water_shortage_on)
        riskType = "Drought"
    }
    fun clickUser(view: View) {
        riskAllOff()
        userButton!!.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
        userImg!!.setImageResource(R.drawable.ico_user_defined_on)
        riskType = "User Defined"
    }
}