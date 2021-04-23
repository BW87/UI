package com.example.test

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class RiskInfoAndWeatherAdapter (fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragmentTitleList = mutableListOf("Risk", "Weather")
    override fun getItem(position: Int): Fragment {
        return when(position){

            0 -> RiskFragment()

            1 -> WeatherFragment()

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