package com.example.test

import android.content.Context
import android.content.Intent
import android.util.TypedValue
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
        holder.itemView.setOnClickListener {

            holder.typeTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            holder.nameTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            holder.distanceTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            holder.mLayout.setBackgroundResource(R.drawable.round_corner_dark_yellowl)

            Intent(context, MedicalDetailActivity::class.java).apply {}.run {
                putExtra("type", holder.typeTextView.text.toString())
                putExtra("hospitalName", holder.nameTextView.text.toString())
                putExtra("itemPosition", position)
                context.startActivity(this)
            }
        }
    }

    inner class MedicalViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
        val typeTextView = view.medical_type!!
        val nameTextView = view.medical_name!!
        val distanceTextView = view.medical_distance!!
        val mLayout = view.aid_item_layout!!


        fun bind(medicalItem : Medical_Item, context : Context){
            typeTextView.text = medicalItem.medicalType
            nameTextView.text = medicalItem.medicalName
            distanceTextView.text = medicalItem.distance.toString() +" Km"

        }
    }

    fun dpToPx(context : Context, dp : Int) : Int{
        val px : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
            .toInt()
        return px
    }
}

