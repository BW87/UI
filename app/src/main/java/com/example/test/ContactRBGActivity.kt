package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_contact_r_b_g.*
import kotlinx.android.synthetic.main.activity_contact_r_b_g.view.*

class ContactRBGActivity : AppCompatActivity() {
    // rbg 본사에 이메일 넣는 용도인 액티비티
    var checked : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_r_b_g)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        email_edit.editText!!.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var input = email_edit.editText!!.text.toString()
                Log.i("test", "test text")
                Log.i("input length", input.length.toString())
                report_detail_edit_count.text= input.length.toString() + "/1000"
            }
        })

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