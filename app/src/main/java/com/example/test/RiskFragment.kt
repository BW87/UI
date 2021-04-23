package com.example.test

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_risk.*
import kotlinx.android.synthetic.main.fragment_risk.view.*

class RiskFragment : Fragment(){
    private val riskItemData : ArrayList<Risk_Item> = ArrayList()
    private lateinit var riskFragmentRecyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        riskItemData.add(Risk_Item("risk_01_storm", "Storm", "Jan 25, 09:26"))
        riskItemData.add(Risk_Item("risk_03_flood", "Flood", "Feb 20, 17:11"))

        var rootView = inflater.inflate(R.layout.fragment_risk, container, false)

        riskFragmentRecyclerView = rootView.risk_recyclerview
        riskFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext()).also{
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
        riskFragmentRecyclerView.adapter = RiskFragmentRecyclerViewAdapter(requireContext(), riskItemData)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}

