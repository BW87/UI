package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        bottom_tab.selectedItemId = R.id.setting

        bottom_tab.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.main -> {
                    val intent = Intent(this, RiskInfoAndWeatherActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                R.id.riskList -> {
                    val intent = Intent(this, RiskListActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                R.id.medicalAid -> {
                    val intent = Intent(this, MedicalActivity::class.java)
                    startActivity(intent)
                    finish()

                    true
                }

                R.id.emergencyContact -> {
                    val intent = Intent(this, EmergencyContactActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.setting -> {
                    true
                }

                else -> false
            }
        }
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