package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_contact_r_b_g.*
import kotlinx.android.synthetic.main.activity_contact_r_b_g.view.*

class ContactRBGActivity : AppCompatActivity() {
    var checked : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_r_b_g)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    fun contactFinish(view: View) {
        finish()
    }

    fun clicked(view: View) {
        if(view.check_button.isPressed && checked){
            view.check_button.setImageResource(R.drawable.chk_box_on)
            checked = false
        } else if(view.check_button.isPressed && !checked){
            view.check_button.setImageResource(R.drawable.chk_box_off)
            checked = true
        }
    }

    fun contactRBGEnd(view: View) {
        finish()
    }
}