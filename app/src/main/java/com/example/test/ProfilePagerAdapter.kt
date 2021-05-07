package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.profile_item.view.*

class ProfilePagerAdapter (val list : ArrayList<Profile_Item>) : PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.profile_item, container, false)

        view.profile_name.text = list[position].name
        view.profile_address.text = list[position].address

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj : Any){
        container.removeView(obj as View?)
    }

    override fun isViewFromObject(view: View, obj : Any) : Boolean{
        return view == obj
    }

    override fun getCount() : Int{
        return list.size
    }
}