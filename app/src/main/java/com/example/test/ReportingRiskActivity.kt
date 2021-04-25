package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ReportingRiskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporting_risk)
    }

    fun reportingBack(view: View) {
        finish()
    }

    fun goNext(view: View) {
        startActivity(Intent(this, ReportingRiskNextActivity::class.java))
    }
}