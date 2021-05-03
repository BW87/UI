package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_personal_information.*

class PersonalInformationActivity : AppCompatActivity() {

    val genderItems = listOf("Male", "Female", "Etc")
    val genderAdapter = ArrayAdapter(this, R.layout.gender_item, genderItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)

        (personal_gender_edit.editText as AutoCompleteTextView).setAdapter(genderAdapter)
    }

    fun personalBack(view: View) {}
}