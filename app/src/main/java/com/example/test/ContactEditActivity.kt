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
    //emergency 액티비티의 recyclerview 아이템을 수정할 때 사용할 액티비티, 기능구현 되있음
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_edit)

        edit_name_edit.getEditText()!!.setText(intent.getStringExtra("name"))
        edit_number_edit.getEditText()!!.setText(intent.getStringExtra("number"))
        position = intent.getIntExtra("position",0)

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
            putExtra("editName", edit_name_edit.getEditText()!!.getText().toString())
            putExtra("editNumber", edit_number_edit.getEditText()!!.getText().toString() )
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