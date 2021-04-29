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

class AnnouncementRecyclerViewAdapter(val context : Context, val announcementItemData : ArrayList<Announcement_Item> ) : RecyclerView.Adapter<AnnouncementViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        return AnnouncementViewHolder(LayoutInflater.from(context).inflate(R.layout.announcement_item, parent, false))
    }

    override fun getItemCount(): Int {
        return announcementItemData.size
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        holder.bind(announcementItemData[position], context)

        holder.itemView.setOnClickListener{
            Intent(context, AnnouncementDetailActivity::class.java).run{
                putExtra("date", announcementItemData[position].date)
                putExtra("title", announcementItemData[position].title)
                putExtra("position", announcementItemData[position].position)
                context.startActivity(this)
            }
        }
    }

}

class AnnouncementViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
    val titleTextView = view.announcement_item_title
    val dateTextView = view.announcement_item_date
    val goDetailButton = view.go_detail_announcement_button

    fun bind(announcementItem : Announcement_Item, context : Context){
        dateTextView.text = announcementItem.date
        titleTextView.text = announcementItem.title

    }

}