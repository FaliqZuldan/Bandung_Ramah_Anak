package com.example.bandungramahanak

import Data.Event
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout
import android.content.Context

class EventAdapter(private val context: Context, private val eventList: List<Event>, private val parentLayout: LinearLayout) {

    fun populate() {
        parentLayout.removeAllViews()
        for (event in eventList) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_event, parentLayout, false)
            val nameTextView = view.findViewById<TextView>(R.id.textViewEventName)
            val dayTextView = view.findViewById<TextView>(R.id.textViewEventDay)
            val timeTextView = view.findViewById<TextView>(R.id.textViewEventTime)

            nameTextView.text = event.nama
            dayTextView.text = event.hari
            timeTextView.text = event.jam

            parentLayout.addView(view)
        }
    }
}
