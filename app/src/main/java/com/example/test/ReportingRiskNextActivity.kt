package com.example.test

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.location.*
import android.os.Build

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import kotlinx.android.synthetic.main.activity_choose_location.*
import kotlinx.android.synthetic.main.activity_medical_detail.*
import kotlinx.android.synthetic.main.activity_reporting_risk_next.*
import java.io.IOException
import java.util.*

class ReportingRiskNextActivity : AppCompatActivity() {

    var riskType : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporting_risk_next)

        riskType = intent.getStringExtra("riskType")!!

        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        current_location_button?.setOnClickListener {
            allOff()
            current_location_button.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
            circle1.setBackgroundResource(R.drawable.yellow_circle)
            current_location_button_text.setTextColor(ContextCompat.getColor(this, R.color.yellow))
            current_location_button_text.setTypeface(current_location_button_text.typeface, Typeface.BOLD)
            mark_img.setImageResource(R.drawable.ico_current_location_off)

            val isGPSEnabled: Boolean = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled: Boolean = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            //매니페스트에 권한이 추가되어 있다해도 여기서 다시 한번 확인해야함
            if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this@ReportingRiskNextActivity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
            } else {
                when { //프로바이더 제공자 활성화 여부 체크
                    isNetworkEnabled -> {
                        val location =
                            lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) //인터넷기반으로 위치를 찾음
                        Log.d("lat and long", "${location!!.latitude} and ${location.longitude}")

                        val address = Geocoder(this@ReportingRiskNextActivity, Locale.getDefault()).getFromLocation(
                            location.latitude, location.longitude,1).first().getAddressLine(0)
                        Log.d("address", address )

                        report_location_address.text = address
                    }
                    isGPSEnabled -> {
                        val location =
                            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) //GPS 기반으로 위치를 찾음
                        Log.d("lat and long", "${location!!.latitude} and ${location.longitude}")

                        val address = Geocoder(this@ReportingRiskNextActivity, Locale.getDefault()).getFromLocation(
                            location.latitude, location.longitude,1).first().getAddressLine(0)
                        Log.d("address", address )

                        report_location_address.text = address
                    }
                    else -> {

                    }
                }
                //몇초 간격과 몇미터를 이동했을시에 호출되는 부분 - 주기적으로 위치 업데이트를 하고 싶다면 사용
                // ****주기적 업데이트를 사용하다가 사용안할시에는 반드시 해제 필요****
                /*lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        1000, //몇초
                        1F,   //몇미터
                        gpsLocationListener)
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        1000,
                        1F,
                        gpsLocationListener)
                //해제부분. 상황에 맞게 잘 구현하자
                lm.removeUpdates(gpsLocationListener)*/
            }
        }
        lm.removeUpdates(gpsLocationListener)

        reporting_search_button.setOnClickListener{
            allOff()
            reporting_search_button.setBackgroundResource(R.drawable.round_corner_dark_yellowl)
            circle2.setBackgroundResource(R.drawable.yellow_circle)
            search_img.setImageResource(R.drawable.ico_search_on)
            report_search_button_text.setTextColor(ContextCompat.getColor(this, R.color.yellow))
            report_search_button_text.setTypeface(report_search_button_text.typeface, Typeface.BOLD)

            Intent(this, ChooseLocationActivity::class.java).run{
                startActivityForResult(this, 0)
            }
        }
    }
    val gpsLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            val provider: String = location.provider
            val longitude: Double = location.longitude
            val latitude: Double = location.latitude
            val altitude: Double = location.altitude
        }

        //아래 3개함수는 형식상 필수부분
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val result = data!!.getStringExtra("address")
                    report_location_address.text = result
                }
                Activity.RESULT_CANCELED -> {

                }
            }
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun allOff(){

        current_location_button.setBackgroundResource(R.drawable.round_corner_dark)
        reporting_search_button.setBackgroundResource(R.drawable.round_corner_dark)
        circle1.setBackgroundResource(R.drawable.dark_circle)
        circle2.setBackgroundResource(R.drawable.dark_circle)
        mark_img.setImageResource(R.drawable.ico_current_location_on)
        search_img.setImageResource(R.drawable.ico_search_off)
        current_location_button_text.setTextColor(ContextCompat.getColor(this, R.color.white))
        current_location_button_text.setTypeface(current_location_button_text.typeface, Typeface.NORMAL)
        report_search_button_text.setTextColor(ContextCompat.getColor(this, R.color.white))
        report_search_button_text.setTypeface(report_search_button_text.typeface, Typeface.NORMAL)

    }
    fun goRiskReportingActivity(view: View) {
        Intent(this, ReportingRiskActivity::class.java).run{
            startActivity(this)
        }
        finish()
    }

    fun goEnd(view: View) {
        startActivity(Intent(this, ReportingRiskEndActivity::class.java).putExtra("riskType", riskType).putExtra("situation", report_detail_edit.text.toString()).putExtra("address", report_location_address.text.toString()))
        finish()
    }

    override fun onBackPressed() {
        Intent(this, ReportingRiskActivity::class.java).run{
            startActivity(this)
        }
        finish()
    }
}