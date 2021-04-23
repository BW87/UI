package com.example.test

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_contact_add.*
import kotlinx.android.synthetic.main.activity_contact_r_b_g.*
import kotlinx.android.synthetic.main.activity_emergency_contact.*

class ContactAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_add)

        edit_name_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                var count : String = edit_name_edit.text.toString()
                if(count.length == 0){
                    small_name.visibility = View.INVISIBLE
                    edit_name_edit.setPadding(38,0,0,0)
                } else {
                    small_name.visibility = View.VISIBLE
                    edit_name_edit.setPadding(38,31,0,0)
                }
            }
        })

        edit_number_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                var count : String = edit_number_edit.text.toString()
                if(count.length == 0){
                    small_number.visibility = View.INVISIBLE
                    edit_number_edit.setPadding(38,0,0,0)
                } else {
                    small_number.visibility = View.VISIBLE
                    edit_number_edit.setPadding(38,31,0,0)
                }
            }
        })
    }

    fun addFinish(view: View) {
        startActivity(Intent(this, EmergencyContactActivity::class.java))
        finish()
    }

    fun editFinish(view: View) {}


    override fun onBackPressed() {
        startActivity(Intent(this, EmergencyContactActivity::class.java))
        finish()
    }

    fun newItem(view: View) {
        Intent(this, EmergencyContactActivity::class.java).apply {  }.run {
            putExtra("newName", edit_name_edit.text.toString())
            putExtra("newNumber", edit_number_edit.text.toString())
            setResult(0, this)
        }
        finish()
    }

    fun modify(view: View) {}
}