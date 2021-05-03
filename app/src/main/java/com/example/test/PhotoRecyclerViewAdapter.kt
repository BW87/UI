package com.example.test

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_emergency_contact.view.*
import kotlinx.android.synthetic.main.announcement_item.view.*
import kotlinx.android.synthetic.main.contact_item.view.*
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoRecyclerViewAdapter(val context : Context, val photoItemData : ArrayList<Photo_Item> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{

        const val TYPE_HEADER : Int = 0
        const val TYPE_ITEM : Int = 1
    }

    var onItemClick : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == TYPE_ITEM){
            val mainView : View = LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false)
            mainView.setOnClickListener(onItemClick)
            PhotoItemHolder(mainView)
        } else {
            val headView : View = LayoutInflater.from(context).inflate(R.layout.photo_recyclerview_header, parent, false)
            PhotoHeaderHolder(headView)
        }
    }

    override fun getItemCount(): Int {
        return photoItemData.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if(isPositionHeader(position)){
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PhotoItemHolder){
            holder.bind(photoItemData[position-1], context)
        }
    }

    private fun isPositionHeader(position: Int): Boolean{
        return position == TYPE_HEADER
    }

}


class PhotoItemHolder(view : View) : RecyclerView.ViewHolder(view){
    val photo = view.photo

    fun bind(photoItem : Photo_Item, context : Context){
        if(photoItem.photo != ""){
            val resourceId = context.resources.getIdentifier(photoItem.photo, "drawable", context.packageName)
            photo?.setImageResource(resourceId)
        } else {
            photo.setImageResource(R.mipmap.ic_launcher)
        }
    }
}

class PhotoHeaderHolder(view : View) : RecyclerView.ViewHolder(view){

    val photoAdd = view.photo_add


}
