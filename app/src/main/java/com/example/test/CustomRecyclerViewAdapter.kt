package com.example.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerViewAdapter(private val context : Context, private val items: ArrayList<Item>) : RecyclerView.Adapter<CustomRecyclerViewAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val itemText = itemView.findViewById<TextView>(R.id.itemName)

        fun bind(item : Item){
            itemText.text = item.text
            itemView.setOnClickListener{
                var num : Int = item.activityNum

                when(num){
                    1 -> Intent(context, RiskInfoAndWeatherActivity::class.java).apply {}.run{context.startActivity(this)}
                    2 -> Intent(context, EmergencyContactActivity::class.java).apply{}.run { context.startActivity(this)}
                    3 -> Intent(context, ContactRBGActivity::class.java).apply{}.run{context.startActivity(this)}
                    4 -> Intent(context, AlarmSettingActivity::class.java).apply{}.run{context.startActivity(this)}
                    5 -> Intent(context, LanguageSettingActivity::class.java).apply{}.run{context.startActivity(this)}
                    6 -> Intent(context, MedicalActivity::class.java).apply {  }.run { context.startActivity(this) }
                    7 -> Intent(context, ReportingRiskActivity::class.java).apply { }.run { context.startActivity(this) }
                    8 -> Intent(context, AnnouncementActivity::class.java).apply{}.run{context.startActivity(this)}
                    9 -> Intent(context, RiskListActivity::class.java).run{context.startActivity(this)}
                    10 -> Intent(context, SettingActivity::class.java).run{context.startActivity(this)}
                    11 -> Intent(context, PersonalInformationActivity::class.java).run{context.startActivity(this)}

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false )
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}