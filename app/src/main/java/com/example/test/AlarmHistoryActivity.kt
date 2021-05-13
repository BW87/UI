package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_alarm_history.*
import kotlinx.android.synthetic.main.activity_alarm_history.view.*

class AlarmHistoryActivity : AppCompatActivity() {
    //sliding drawer에 들어갈 액티비티

    private val adapter by lazy{AlarmHistoryAdapter(supportFragmentManager)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_history)

        alarm_view_pager.adapter = AlarmHistoryActivity@adapter
        alarm_tab.setupWithViewPager(alarm_view_pager)
    }

}