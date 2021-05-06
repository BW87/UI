package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_alarm_history_risk.view.*

class AlarmHistoryRiskFragment : Fragment() {
    val alarmHistoryRiskData : ArrayList<AlarmHistoryRisk_Item> = ArrayList()
    lateinit var alarmHistoryRiskRecyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        alarmHistoryRiskData.add(AlarmHistoryRisk_Item("ico_artificial_satellite_gray_24_px", "Storm", "14 min ago"))
        alarmHistoryRiskData.add(AlarmHistoryRisk_Item("ico_user_reporting_gray_24_px", "Flood", "2 days 14 min ago"))

        var rootView = inflater.inflate(R.layout.fragment_alarm_history_risk, container, false)

        alarmHistoryRiskRecyclerView = rootView.alarm_history_risk_recyclerview
        alarmHistoryRiskRecyclerView.layoutManager = LinearLayoutManager(requireContext()).also{
            it.orientation = LinearLayoutManager.VERTICAL
        }

        alarmHistoryRiskRecyclerView.adapter = AlarmHistoryRiskFragmentRecyclerViewAdapter(requireContext(), alarmHistoryRiskData)


        // Inflate the layout for this fragment
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}