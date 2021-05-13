package com.example.test

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_choose_location.*
import kotlinx.android.synthetic.main.activity_main_current_location.*

class MainCurrentLocationActivity : AppCompatActivity() {
    // riskinfo and weather 액티비티에서 map button 누르면 자기 위치 보여주는 mapview가 있는 액티비티

    val PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION)

    val REQUEST_PERMISSION_CODE = 1

    val DEFAULT_ZOOM_LEVEL = 14f


    var googleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_current_location)

        main_mapview.onCreate(savedInstanceState)

        if(checkPermissions()){
            initMap()
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_PERMISSION_CODE)
        }
    }

    override fun onResume() {
        super.onResume()
        main_mapview.onResume()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        initMap()
    }

    private fun checkPermissions(): Boolean {

        for (permission in PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }


    @SuppressLint("MissingPermission")
    fun initMap() {
        main_mapview.getMapAsync {

            googleMap = it

            when {
                checkPermissions() -> {
                    it.isMyLocationEnabled = true
                    it.moveCamera(CameraUpdateFactory.newLatLngZoom(getMyLocation(), DEFAULT_ZOOM_LEVEL))
                    it.addMarker(MarkerOptions().position(getMyLocation()))
                }
                else -> {
                    it.moveCamera(CameraUpdateFactory.newLatLngZoom(getMyLocation(), DEFAULT_ZOOM_LEVEL))
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun getMyLocation(): LatLng {

        val locationProvider: String = LocationManager.GPS_PROVIDER

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val lastKnownLocation: Location = locationManager.getLastKnownLocation(locationProvider)!!

        return LatLng(lastKnownLocation.latitude, lastKnownLocation.longitude)
    }
}