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
import kotlinx.android.synthetic.main.risk_list_item.view.*

class RiskListRecyclerViewAdapter(val context : Context, val riskListItemData : ArrayList<Risk_List_Item> ) : RecyclerView.Adapter<RiskListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiskListViewHolder {
        return RiskListViewHolder(LayoutInflater.from(context).inflate(R.layout.risk_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return riskListItemData.size
    }

    override fun onBindViewHolder(holder: RiskListViewHolder, position: Int) {
        holder.bind(riskListItemData[position], context)

        holder.itemView.setOnClickListener {

            Intent(context, RiskListDetailActivity::class.java).run{
                putExtra("riskType", holder.riskListTitle.text.toString())
                putExtra("riskElapsed", holder.riskElapsedTime.text.toString())
                putExtra("riskDistance", holder.riskDistance.text.toString())
                context.startActivity(this)
            }
        }
    }

}

class RiskListViewHolder(view : View) : RecyclerView.ViewHolder(view!!){

    val riskListTitle = view.risk_list_item_title
    val riskListTitleImg = view.risk_list_title_img
    val riskElapsedTime = view.risk_elapsed_time_value
    val riskDistance = view.risk_distance_value

    fun bind(riskListItem : Risk_List_Item, context : Context){

        riskListTitle.text = riskListItem.riskType
        riskElapsedTime.text = riskListItem.elapsedTime
        riskDistance.text = riskListItem.distance

        if(riskListItem.riskTypeImg != ""){
            val resourceId = context.resources.getIdentifier(riskListItem.riskTypeImg, "drawable", context.packageName)
            riskListTitleImg?.setImageResource(resourceId)
        } else {
            riskListTitleImg.setImageResource(R.mipmap.ic_launcher)
        }

    }

}