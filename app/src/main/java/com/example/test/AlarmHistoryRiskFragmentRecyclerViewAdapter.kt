package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alarm_history_risk_item.view.*
import kotlinx.android.synthetic.main.risk_item.view.*

class AlarmHistoryRiskFragmentRecyclerViewAdapter(val context : Context, val alarmHistoryRiskList: ArrayList<AlarmHistoryRisk_Item> ) : RecyclerView.Adapter<AlarmRiskViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmRiskViewHolder {
        return AlarmRiskViewHolder(LayoutInflater.from(context).inflate(R.layout.alarm_history_risk_item, parent, false))
    }

    override fun getItemCount(): Int {
        return alarmHistoryRiskList.size
    }

    override fun onBindViewHolder(holder: AlarmRiskViewHolder, position: Int) {
        holder.bind(alarmHistoryRiskList[position], context)
    }
}

class AlarmRiskViewHolder(view : View) : RecyclerView.ViewHolder(view!!){

    val alarmImg = view.alarm_history_risk_img
    val alarmName = view.alarm_history_risk_name
    val alarmTime = view.alarm_history_risk_time

    fun bind(alarmHistoryRiskItem : AlarmHistoryRisk_Item, context : Context){

        alarmName.text = alarmHistoryRiskItem.aName
        alarmTime.text = alarmHistoryRiskItem.aTime
        if(alarmHistoryRiskItem.img != ""){
            val resourceId = context.resources.getIdentifier(alarmHistoryRiskItem.img, "drawable", context.packageName)
            alarmImg.setImageResource(resourceId)
        } else {
            alarmImg.setImageResource(R.mipmap.ic_launcher)
        }

    }

}