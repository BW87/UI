package com.example.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_emergency_contact.view.*
import kotlinx.android.synthetic.main.announcement_item.view.*
import kotlinx.android.synthetic.main.contact_item.view.*
import kotlinx.android.synthetic.main.profile_item.view.*

class ProfileRecyclerViewAdapter(val context : Context, val profileItemData : ArrayList<Profile_Item> ) : RecyclerView.Adapter<ProfileRecyclerViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileRecyclerViewHolder {
        return ProfileRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.profile_item, parent, false))
    }

    override fun getItemCount(): Int {
        return profileItemData.size
    }

    override fun onBindViewHolder(holder: ProfileRecyclerViewHolder, position: Int) {
        holder.bind(profileItemData[position], context)

        }
    }

class ProfileRecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view!!){

    val profileName = view.profile_name
    val profileAddress = view.profile_address

    fun bind(profileItem : Profile_Item, context : Context){

        profileName.text = profileItem.name
        profileAddress.text = profileItem.address

    }

}