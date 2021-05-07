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


    }

    fun addFinish(view: View) {
        Intent(this, EmergencyContactActivity::class.java).run{
            setResult(4, this)
        }
        finish()
    }


    override fun onBackPressed() {
        Intent(this, EmergencyContactActivity::class.java).run{
            setResult(5, this)
        }
        finish()
    }

    fun newItem(view: View) {
        Intent(this, EmergencyContactActivity::class.java).apply {  }.run {
            putExtra("newName", add_name_edit.getEditText()!!.getText().toString())
            putExtra("newNumber", add_number_edit.getEditText()!!.getText().toString())
            setResult(0, this)
        }
        finish()
    }


}