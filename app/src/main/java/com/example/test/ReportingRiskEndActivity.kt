package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reporting_risk_end.*

class ReportingRiskEndActivity : AppCompatActivity() {
    // 제닌 신고 마지막 액티비티

    var riskType : String = ""
    var riskAddress : String = ""
    var situation : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporting_risk_end)

        riskType = intent.getStringExtra("riskType")!!
        riskAddress = intent.getStringExtra("address")!!
        situation = intent.getStringExtra("situation")!!

        end_report_type_text.text = riskType
        end_report_location_text.text = riskAddress
        end_report_situation_text.text = situation
    }

    fun finishReport(view: View) {
        finish()
    }

    fun goDone(view: View) {
        finish()
    }
}