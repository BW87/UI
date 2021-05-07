package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
    }

    fun settingGoAlarm(view: View) {
        startActivity(Intent(this, AlarmSettingActivity::class.java))
    }
    fun settingGoEmergency(view: View) {
        startActivity(Intent(this, EmergencyContactActivity::class.java))
    }
    fun settingGoLanguage(view: View) {
        startActivity(Intent(this, LanguageSettingActivity::class.java))
    }
    fun settingGoPersonal(view: View) {
        startActivity(Intent(this, PersonalInformationActivity::class.java))
    }
    fun settingGoContact(view: View) {
        startActivity(Intent(this, ContactRBGActivity::class.java))
    }
}