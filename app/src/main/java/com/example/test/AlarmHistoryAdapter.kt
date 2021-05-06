package com.example.test

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AlarmHistoryAdapter (fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragmentTitleList = mutableListOf("Risk", "Announcement")
    override fun getItem(position: Int): Fragment {
        return when(position){

            0 -> AlarmHistoryRiskFragment()

            1 -> AlarmHistoryAnnouncementFragment()

            else -> TestFragment()
        }
    }

    override fun getCount() = 2

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}