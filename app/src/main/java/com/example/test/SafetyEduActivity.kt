package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SafetyEduActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safety_edu)
    }

    fun safetyBack(view: View) {
        finish()
    }

    fun goStormEdu(view: View) {
        Intent(this, SafetyEduDetailActivity::class.java).run{
            putExtra("eduName","Storm")
            startActivity(this)
        }
    }
    fun goFireEdu(view: View) {
        Intent(this, SafetyEduDetailActivity::class.java).run {
            putExtra("eduName","Fire")
            startActivity(this)
        }
    }
    fun goFloodEdu(view: View) {
        Intent(this, SafetyEduDetailActivity::class.java).run{
            putExtra("eduName","Flood")
            startActivity(this)
        }
    }
    fun goWaterShortageEdu(view: View) {
        Intent(this, SafetyEduDetailActivity::class.java).run{
            putExtra("eduName","Water Shortage")
            startActivity(this)
        }
    }
}