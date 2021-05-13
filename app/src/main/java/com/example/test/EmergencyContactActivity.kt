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
    //긴급 연락망을 보여주고 추가하고 삭제하고 수정할 수 있는 액티비티
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

    fun goMainActivity(view: View) {
        finish()
    }

    fun goAdd(view: View) {
            val go = Intent(this, ContactAddActivity::class.java)
            startActivityForResult(go, 0)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 0){

            when(resultCode){
                0 -> {
                    val addName = data?.getStringExtra("newName")!!
                    val addNumber = data?.getStringExtra("newNumber")!!
                    mAdapter.addItem(Contact_Item("ico_call_default", addName, addNumber))
                    mAdapter.notifyDataSetChanged()
                }
                else -> return

            }
        } else if(requestCode == 1){
            when(resultCode){
                    0 -> {
                    val editName = data?.getStringExtra("editName")!!
                    val editNumber = data?.getStringExtra("editNumber")!!
                    val editPosition = data?.getIntExtra("editPosition",0)
                    mAdapter.modifyItem(Contact_Item("ico_call_default", editName, editNumber), editPosition)
                    mAdapter.notifyDataSetChanged()
                    }

                    1 -> {
                        val dPosition = data!!.getIntExtra("position",0)
                        mAdapter.deleteItem(dPosition)
                        mAdapter.notifyDataSetChanged()
                    }
                else -> return
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
