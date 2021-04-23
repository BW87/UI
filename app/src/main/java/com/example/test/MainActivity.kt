package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Item>()
        list.add(Item("Real-time Risk Info & Weather",1))
        list.add(Item("Emergency Contact",2))
        list.add(Item("Contact RBG",3))
        list.add(Item("Alarm Setting",4))
        list.add(Item("Language Setting",5))
        list.add(Item("Medical Aid",6))
        list.add(Item("Reporting risk",7))
        list.add(Item("Announcement",8))
        list.add(Item("Connecting satellite",9))

        val mAdapter = CustomRecyclerViewAdapter(this, list)
        main_recyclerview.adapter =mAdapter
    }
}