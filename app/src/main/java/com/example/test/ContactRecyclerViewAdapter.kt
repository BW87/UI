package com.example.test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contact_edit.view.*
import kotlinx.android.synthetic.main.activity_emergency_contact.view.*
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactRecyclerViewAdapter(val context : Context, val contactItemList : ArrayList<Contact_Item> ) : RecyclerView.Adapter<ContactViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false))
    }

    override fun getItemCount(): Int {
        return contactItemList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactItemList[position], context)

        holder.deleteButton.setOnClickListener{
            deleteItem(position)
        }


        holder.editButton.setOnClickListener{

            val intent = Intent(context, ContactEditActivity::class.java)
            intent.putExtra("name", contactItemList[position].contactName)
            intent.putExtra("number", contactItemList[position].contactNumber)
            intent.putExtra("position", position)

            startActivityForResult(holder.itemView.context as Activity,intent, 1,null)

        }
    }

    fun addItem(item : Contact_Item){
        contactItemList.add(item)

        notifyDataSetChanged()
    }

    fun modifyItem(item : Contact_Item, position : Int){
        val reName = item.contactName
        val reNumber = item.contactNumber

        contactItemList[position].contactName = reName
        contactItemList[position].contactNumber = reNumber

        notifyDataSetChanged()
    }

    fun deleteItem(position : Int){
            contactItemList.removeAt(position)
            notifyDataSetChanged()
    }
}

class ContactViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
    val contactNum = view.contact_number
    val contactName = view.contact_name
    val contactImg = view.contact_title_image
    val editButton = view.modify_button
    val deleteButton = view.contact_delete_button

    fun bind(contactItem : Contact_Item, context : Context){
        contactNum.text = contactItem.contactNumber
        contactName.text = contactItem.contactName

        if(contactItem.contactImage != ""){
            val resourceId = context.resources.getIdentifier(contactItem.contactImage, "drawable", context.packageName)
            contactImg?.setImageResource(resourceId)
        } else {
            contactImg.setImageResource(R.mipmap.ic_launcher)
        }
    }

}