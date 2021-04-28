package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_safety_edu_detail.*

class SafetyEduDetailActivity : AppCompatActivity() {

    var type : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safety_edu_detail)

        type = intent.getStringExtra("eduName")!!
        safety_edu_detail_type.text = type
    }

    fun safetyDetailBack(view: View) {}
}