package com.example.test

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_emergency_contact.*
import kotlinx.android.synthetic.main.contact_item.*

class EmergencyContactActivity : AppCompatActivity() {
    private val contactItemData : ArrayList<Contact_Item> = ArrayList()
    private lateinit var contactRecyclerView : RecyclerView
    val mAdapter = ContactRecyclerViewAdapter(this, contactItemData)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contact)

        contactItemData.add(Contact_Item("ico_call_default", "Emergency", "02-3277-5000"))
        contactItemData.add(Contact_Item("ico_call_default", "Home", "031-123-4567"))
        contactItemData.add(Contact_Item("ico_call_default", "Name", "010-1234-5678"))



        contactRecyclerView = contact_recyclerview
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactRecyclerView.addItemDecoration(VerticalItemDecorator(16))
        contactRecyclerView.adapter = mAdapter
    }

    override fun onResume() {
        super.onResume()

        /*if(intent.hasExtra("newName") && intent.hasExtra("newNumber")) {
            val addName = intent.getStringExtra("newName")!!
            val addNumber = intent.getStringExtra("newNumber")!!

            mAdapter.addItem(Contact_Item("ico_call_default", addName, addNumber))
            mAdapter.notifyDataSetChanged()
        }*/

        if(intent.hasExtra("position") && intent.hasExtra("mName") && intent.hasExtra("mNumber")){

            val editName = intent.getStringExtra("mName")!!
            val editNumber = intent.getStringExtra("mNumber")!!
            val editPosition = intent.getIntExtra("position",0)

            mAdapter.modifyItem(Contact_Item("ico_call_default", editName, editNumber), editPosition)
            mAdapter.notifyDataSetChanged()
        }
    }

    fun goMainActivity(view: View) {
        val back = Intent(this, MainActivity::class.java)
        startActivity(back)
        finish()
    }

    fun goAdd(view: View) {
            val go = Intent(this, ContactAddActivity::class.java)
            startActivityForResult(go, 0)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            0 -> {
                val addName = data?.getStringExtra("newName")!!
                val addNumber = data?.getStringExtra("newNumber")!!
                mAdapter.addItem(Contact_Item("ico_call_default", addName, addNumber))
                mAdapter.notifyDataSetChanged()
            }

        }
    }

    override fun onBackPressed() {
        finish()
    }
}


class VerticalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration(){
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divHeight
        outRect.bottom = divHeight
    }
}


class VerticalItemDecorator2(private val divHeight : Int) : RecyclerView.ItemDecoration(){
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = divHeight
    }
}