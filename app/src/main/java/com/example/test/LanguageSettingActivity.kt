package com.example.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_language_setting.*
import kotlinx.android.synthetic.main.activity_language_setting.view.*

class LanguageSettingActivity : AppCompatActivity() {

    var osButton : Boolean = false
    var engButton : Boolean = true
    var khmerButton : Boolean = true
    var vietButton : Boolean = true
    var korButton : Boolean = true

    var osTextView : TextView? = null
    var engTextView : TextView? = null
    var khmerTextView : TextView? = null
    var vietTextView : TextView? = null
    var korTextView : TextView? = null


    val context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_setting)

        osTextView = os_text
        engTextView = eng_test
        khmerTextView = khmer_test
        vietTextView = viet_test
        korTextView = kor_test

    }

    fun allOff(){
        os_lang.setBackgroundResource(R.drawable.select_off_long)
        eng.setBackgroundResource(R.drawable.select_off_long)
        khmer.setBackgroundResource(R.drawable.select_off_long)
        viet.setBackgroundResource(R.drawable.select_off_long)
        kor.setBackgroundResource(R.drawable.select_off_long)

        osTextView!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        engTextView!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        khmerTextView!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        vietTextView!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
        korTextView!!.setTextColor(ContextCompat.getColor(context, R.color.gray))
    }

    fun languageFinish(view: View) {
        finish()
    }

    fun osClick(view: View) {
        allOff()
        view.os_lang.setBackgroundResource(R.drawable.select_on_long)
        osTextView!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
    }
    fun korClick(view: View) {
        allOff()
        view.kor.setBackgroundResource(R.drawable.select_on_long)
        korTextView!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
    }
    fun vietClick(view: View) {
        allOff()
        view.viet.setBackgroundResource(R.drawable.select_on_long)
        vietTextView!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
    }
    fun khmerClick(view: View) {
        allOff()
        view.khmer.setBackgroundResource(R.drawable.select_on_long)
        khmerTextView!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
    }
    fun engClick(view: View) {
        allOff()
        view.eng.setBackgroundResource(R.drawable.select_on_long)
        engTextView!!.setTextColor(ContextCompat.getColor(context, R.color.yellow))
    }
}