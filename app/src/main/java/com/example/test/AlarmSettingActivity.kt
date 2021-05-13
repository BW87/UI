package com.example.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_alarm_setting.*
import kotlinx.android.synthetic.main.activity_alarm_setting.view.*

class AlarmSettingActivity : AppCompatActivity() {
    //AlarmSetting 액티비티 버튼 많은 화면
    var rangeChecked : Boolean = true
    var locationChecked : Boolean = true

    var leftRangeButton : Boolean = true
    var rightRangeButton : Boolean = true

    var stormButton : Boolean =true
    var floodButton : Boolean =true
    var droughtButton : Boolean =true
    var fireButton : Boolean =true
    var userButton : Boolean =true
    var tidemButton : Boolean =true

    var rangeCheckButton : ImageButton? = null
    var locationCheckButton : ImageButton? = null

    var rangeLeftButton : ImageButton? = null
    var rangeRightButton : ImageButton? = null

    var buttonStorm : ImageButton? = null
    var buttonFlood : ImageButton? = null
    var buttonDrought : ImageButton? = null
    var buttonFire : ImageButton? = null
    var buttonUser : ImageButton? = null
    var buttonTide : ImageButton? = null

    var leftLocationColor : TextView? = null
    var rightLocationColor : TextView? = null
    var stormColor : TextView? = null
    var floodColor : TextView? = null
    var droughtColor : TextView? = null
    var fireColor : TextView? = null
    var userColor : TextView? = null
    var tideColor : TextView? = null

    val context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_setting)


        rangeCheckButton = range_check
        locationCheckButton = location_check

        rangeLeftButton = left_range_button
        rangeRightButton = right_range_button

        buttonStorm = storm_button
        buttonDrought = drought_button
        buttonFire = fire_button
        buttonFlood = flood_button
        buttonStorm = storm_button
        buttonUser = user_button
        buttonTide = tide_button


        leftLocationColor = near
        rightLocationColor = tenkm
        stormColor = storm
        floodColor = flood
        droughtColor = drought
        fireColor = fire
        userColor = user
        tideColor = tide

        bottom_tab.selectedItemId = R.id.setting
    }

    fun rangeAllOff(){

        rangeLeftButton!!.setBackgroundResource(R.drawable.select_off)
        rangeRightButton!!.setBackgroundResource(R.drawable.select_off)
        leftLocationColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        rightLocationColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        leftRangeButton = true
        rightRangeButton = true

    }

    fun riskAllOff(){
        buttonStorm!!.setBackgroundResource(R.drawable.select_off)
        buttonFire!!.setBackgroundResource(R.drawable.select_off)
        buttonFlood!!.setBackgroundResource(R.drawable.select_off)
        buttonDrought!!.setBackgroundResource(R.drawable.select_off)
        buttonUser!!.setBackgroundResource(R.drawable.select_off)
        buttonTide!!.setBackgroundResource(R.drawable.select_off)

        stormColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        floodColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        droughtColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        fireColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        userColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        tideColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))

        stormButton = true
        fireButton = true
        floodButton = true
        droughtButton = true
        userButton = true
        tidemButton = true

    }

    fun alarmFinish(view: View) {
        finish()
    }

    fun rangeCheckClick(view: View) {
        if(rangeCheckButton!!.isPressed && rangeChecked){
            rangeCheckButton!!.setImageResource(R.drawable.ico_chk_on)
            rangeChecked = false

        } else if(rangeCheckButton!!.isPressed && !rangeChecked){
            rangeCheckButton!!.setImageResource(R.drawable.ico_chk_off)
            rangeChecked = true
            rangeAllOff()
            riskAllOff()
        }

        if(!rangeChecked){
            rangeAllOff()
            rangeLeftButton!!.setBackgroundResource(R.drawable.select_on)
            leftLocationColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        }
    }

    fun locationCheckClick(view: View) {
        if(view.location_check.isPressed && locationChecked){
            view.location_check.setImageResource(R.drawable.ico_chk_on)
            locationChecked = false
        } else if(view.location_check.isPressed && !locationChecked){
            view.location_check.setImageResource(R.drawable.ico_chk_off)
            locationChecked = true
        }
    }

    fun leftLocationButtonClick(view : View){
        if(!rangeChecked){
            rangeAllOff()
            rangeLeftButton!!.setBackgroundResource(R.drawable.select_on)
            leftLocationColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        }
    }

    fun rightRangeButtonClick(view: View) {
        if(!rangeChecked) {
            rangeAllOff()
            rangeRightButton!!.setBackgroundResource(R.drawable.select_on)
            rightLocationColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
        }
    }

    fun stormButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.storm_button.isPressed && stormButton) {
                view.storm_button.setBackgroundResource(R.drawable.select_on)
                stormColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                stormButton = false
            } else if (view.storm_button.isPressed && !stormButton) {
                view.storm_button.setBackgroundResource(R.drawable.select_off)
                stormColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                stormButton = true
            }
        }
    }
    fun floodButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.flood_button.isPressed && floodButton) {
                view.flood_button.setBackgroundResource(R.drawable.select_on)
                floodColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                floodButton = false
            } else if (view.flood_button.isPressed && !floodButton) {
                view.flood_button.setBackgroundResource(R.drawable.select_off)
                floodColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                floodButton = true
            }
        }

    }
    fun droughtButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.drought_button.isPressed && droughtButton) {
                view.drought_button.setBackgroundResource(R.drawable.select_on)
                droughtColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                droughtButton = false
            } else if (view.drought_button.isPressed && !droughtButton) {
                view.drought_button.setBackgroundResource(R.drawable.select_off)
                droughtColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                droughtButton = true
            }
        }
    }
    fun fireButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.fire_button.isPressed && fireButton) {
                view.fire_button.setBackgroundResource(R.drawable.select_on)
                fireColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                fireButton = false
            } else if (view.fire_button.isPressed && !fireButton) {
                view.fire_button.setBackgroundResource(R.drawable.select_off)
                fireColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                fireButton = true
            }
        }

    }
    fun userButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.user_button.isPressed && userButton) {
                view.user_button.setBackgroundResource(R.drawable.select_on)
                userColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                userButton = false
            } else if (view.user_button.isPressed && !userButton) {
                view.user_button.setBackgroundResource(R.drawable.select_off)
                userColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                userButton = true
            }
        }
    }
    fun tideButtonClick(view: View) {
        if(!rangeChecked) {
            if (view.tide_button.isPressed && tidemButton) {
                view.tide_button.setBackgroundResource(R.drawable.select_on)
                tideColor!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                tidemButton = false
            } else if (view.tide_button.isPressed && !tidemButton) {
                view.tide_button.setBackgroundResource(R.drawable.select_off)
                tideColor!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
                tidemButton = true
            }
        }
    }

}