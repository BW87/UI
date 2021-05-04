package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.risk_item.view.*

class RiskFragmentRecyclerViewAdapter(val context : Context, val riskItemList: ArrayList<Risk_Item> ) : RecyclerView.Adapter<RiskViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiskViewHolder {
        return RiskViewHolder(LayoutInflater.from(context).inflate(R.layout.risk_item, parent, false))
    }

    override fun getItemCount(): Int {
        return riskItemList.size
    }

    override fun onBindViewHolder(holder: RiskViewHolder, position: Int) {
        holder.bind(riskItemList[position], context)
    }
}

class RiskViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
    val riskName = view.risk_name
    val riskDate = view.risk_date
    val riskImage = view.risk_image

    fun bind(riskItem : Risk_Item, context : Context){
        riskName.text = riskItem.riskNameValue
        riskDate.text = riskItem.riskDateValue
        if(riskItem.riskImage != "") {
            val resourceId = context.resources.getIdentifier(riskItem.riskImage, "drawable", context.packageName)
            riskImage?.setBackgroundResource(resourceId)
        } else {
            riskImage?.setBackgroundResource(R.mipmap.ic_launcher)
        }
    }

}