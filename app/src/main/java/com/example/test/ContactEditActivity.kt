package com.example.test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import kotlinx.android.synthetic.main.activity_contact_edit.*

class ContactEditActivity : AppCompatActivity() {

    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_edit)

        edit_name_edit.setText(intent.getStringExtra("name"))
        edit_number_edit.setText(intent.getStringExtra("number"))
        position = intent.getIntExtra("position",0)

        edit_name_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var count : String = edit_name_edit.text.toString()
                if(count.length == 0){
                    edit_small_name.visibility = View.INVISIBLE
                    edit_name_edit.setPadding(38,0,0,0)
                } else {
                    edit_small_name.visibility = View.VISIBLE
                    edit_name_edit.setPadding(38,31,0,0)
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var count : String = edit_name_edit.text.toString()
                if(count.length == 0){
                    edit_small_name.visibility = View.INVISIBLE
                    edit_name_edit.setPadding(38,0,0,0)
                } else {
                    edit_small_name.visibility = View.VISIBLE
                    edit_name_edit.setPadding(38,31,0,0)
                }

            }
        })

        edit_number_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var count : String = edit_name_edit.text.toString()
                if(count.length == 0){
                    edit_small_name.visibility = View.INVISIBLE
                    edit_number_edit.setPadding(dpToPx(applicationContext, 16),0,0,0)
                } else {
                    edit_small_name.visibility = View.VISIBLE
                    edit_number_edit.setPadding(dpToPx(applicationContext, 16),dpToPx(applicationContext, 14),0,0)
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var count : String = edit_number_edit.text.toString()
                if(count.length == 0){
                    edit_small_number.visibility = View.INVISIBLE
                    edit_number_edit.setPadding(dpToPx(applicationContext, 16),0,0,0)
                } else {
                    edit_small_number.visibility = View.VISIBLE
                    edit_number_edit.setPadding(dpToPx(applicationContext, 16),dpToPx(applicationContext, 14),0,0)
                }

            }
        })
    }
    fun editFinish(view: View) {
        Intent(this, EmergencyContactActivity::class.java).run{
            setResult(2, this)
        }
        finish()
    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
            .toInt()
        return px
    }

    fun modify(view: View) {
        Intent(this, EmergencyContactActivity::class.java).run{
            putExtra("editName", edit_name_edit.text.toString())
            putExtra("editNumber", edit_number_edit.text.toString() )
            putExtra("editPosition", position)
            setResult(0, this)
        }
        finish()
    }
    fun deleteButton(view: View) {
        Intent(this, EmergencyContactActivity::class.java).run{
            putExtra("position", position)
            setResult(1, this)
        }
        finish()
    }

    override fun onBackPressed() {
        Intent(this, EmergencyContactActivity::class.java).run{
            setResult(2, this)
        }
        finish()
    }
}