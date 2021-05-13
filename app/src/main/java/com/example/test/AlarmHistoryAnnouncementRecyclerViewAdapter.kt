package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alarm_history_announce_item.view.*
import kotlinx.android.synthetic.main.alarm_history_risk_item.view.*
import kotlinx.android.synthetic.main.risk_item.view.*

class AlarmHistoryAnnouncementRecyclerViewAdapter(val context : Context, val alarmHistoryAnnouncementItem: ArrayList<AlarmHistoryAnnouncement_Item> ) : RecyclerView.Adapter<AlarmAnnouncementViewHolder>(){
    //Announcement RecyclerView 어댑터
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmAnnouncementViewHolder {
        return AlarmAnnouncementViewHolder(LayoutInflater.from(context).inflate(R.layout.alarm_history_announce_item, parent, false))
    }

    override fun getItemCount(): Int {
        return alarmHistoryAnnouncementItem.size
    }

    override fun onBindViewHolder(holder: AlarmAnnouncementViewHolder, position: Int) {
        holder.bind(alarmHistoryAnnouncementItem[position], context)
    }
}

class AlarmAnnouncementViewHolder(view : View) : RecyclerView.ViewHolder(view!!){

    val announcementName = view.alarm_history_announce_name
    val announcementTime = view.alarm_history_announce_time

    fun bind(alarmHistoryAnnouncementItem : AlarmHistoryAnnouncement_Item, context : Context){

        announcementName.text = alarmHistoryAnnouncementItem.announceName
        announcementTime.text = alarmHistoryAnnouncementItem.announceTime

    }

}