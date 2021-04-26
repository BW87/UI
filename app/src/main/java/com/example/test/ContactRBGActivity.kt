package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_contact_r_b_g.*
import kotlinx.android.synthetic.main.activity_contact_r_b_g.view.*

class ContactRBGActivity : AppCompatActivity() {
    var checked : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_r_b_g)

        question_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var count : String = question_edit.text.toString()
                report_detail_edit_count.setText(count.length.toString() + "/1000")
            }
        })
    }

    fun contactFinish(view: View) {
        Intent(this, MainActivity::class.java).apply{}.run{
            startActivity(this)
            finish()
        }
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
}