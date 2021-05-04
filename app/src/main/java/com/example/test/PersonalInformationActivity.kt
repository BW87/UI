package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_personal_information.*

class PersonalInformationActivity : AppCompatActivity() {

    val genderItems = listOf("Male", "Female", "Etc")
    val bloodItems = listOf("A", "B", "O", "AB")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)

        val genderAdapter = ArrayAdapter(this, R.layout.gender_item, genderItems)
        (personal_gender_edit.editText as AutoCompleteTextView).setAdapter(genderAdapter)

        val bloodAdapter = ArrayAdapter(this, R.layout.blood_type_item, bloodItems)
        (blood_type_edit.editText as AutoCompleteTextView).setAdapter(bloodAdapter)

        
    }

    fun personalBack(view: View) {
        finish()
    }

    fun save(view: View) {
        finish()
    }
}