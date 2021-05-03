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
import kotlinx.android.synthetic.main.comment_item.view.*
import kotlinx.android.synthetic.main.contact_item.view.*

class CommentsRecyclerViewAdapter(val context : Context, val commentItemData : ArrayList<Comment_Item> ) : RecyclerView.Adapter<CommentViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false))
    }

    override fun getItemCount(): Int {
        return commentItemData.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(commentItemData[position], context)
    }

}

class CommentViewHolder(view : View) : RecyclerView.ViewHolder(view!!){
    val commentName = view.comment_name
    val commentContent = view.comment_value
    val commentTime = view.comment_time

    fun bind(commentItem : Comment_Item, context : Context){

        commentName.text = commentItem.name
        commentContent.text = commentItem.content
        commentTime.text = commentItem.time

    }

}