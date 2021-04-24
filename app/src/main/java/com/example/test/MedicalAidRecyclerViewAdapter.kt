package com.example.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.aid_item.view.*
import kotlinx.android.synthetic.main.risk_item.view.*

class MedicalAidRecyclerViewAdapter(val context : Context, val medicalItemList: ArrayList<Medical_Item> ) : RecyclerView.Adapter<MedicalAidRecyclerViewAdapter.MedicalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicalViewHolder {
        return MedicalViewHolder(LayoutInflater.from(context).inflate(R.layout.aid_item, parent, false))
    }

    override fun getItemCount(): Int {
        return medicalItemList.size
    }

    override fun onBindViewHolder(holder: MedicalViewHolder, position: Int) {
        holder.bind(medicalItemList[position], context)
    }

    inner class MedicalViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
        val typeTextView = view.medical_type!!
        val nameTextView = view.medical_name!!
        val distanceTextView = view.medical_distance!!
        val layout = view.aid_item_layout!!

        var check : Boolean = false

        fun bind(medicalItem : Medical_Item, context : Context){

            typeTextView.text = medicalItem.medicalType
            nameTextView.text = medicalItem.medicalName
            distanceTextView.text = medicalItem.distance.toString() +" Km"

            itemView.setOnClickListener{
                if(!check) {
                    typeTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    nameTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    distanceTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    layout.setBackgroundResource(R.drawable.medical_aid_on)
                    check = true
                } else if(check){
                    typeTextView.setTextColor(ContextCompat.getColor(context, R.color.gray))
                    nameTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
                    distanceTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
                    layout.setBackgroundResource(R.drawable.medical_aid_off)
                    check = false
                }
            }
        }
    }
}

