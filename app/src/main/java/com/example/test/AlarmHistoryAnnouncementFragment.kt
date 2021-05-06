package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_alarm_history_announcement.view.*


class AlarmHistoryAnnouncementFragment : Fragment() {

    val alarmHistoryAnnouncementData : ArrayList<AlarmHistoryAnnouncement_Item> = ArrayList()
    lateinit var alarmHistoryAnnouncementRecyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        alarmHistoryAnnouncementData.add(AlarmHistoryAnnouncement_Item("Please check the announcement","3 days 1 hours ago"))

        var rootView = inflater.inflate(R.layout.fragment_alarm_history_announcement, container, false)

        alarmHistoryAnnouncementRecyclerView = rootView.alarm_history_announcement_recyclerview
        alarmHistoryAnnouncementRecyclerView.layoutManager = LinearLayoutManager(requireContext()).also{
            it.orientation = LinearLayoutManager.VERTICAL
        }

        alarmHistoryAnnouncementRecyclerView.adapter = AlarmHistoryAnnouncementRecyclerViewAdapter(requireContext(), alarmHistoryAnnouncementData)

        // Inflate the layout for this fragment
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
    }
}