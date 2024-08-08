package com.example.bandungramahanak

import Data.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout
import android.content.Context

class ActivityAdapter(private val context: Context, private val activityList: List<Activity>, private val parentLayout: LinearLayout) {

    fun populate() {
        parentLayout.removeAllViews()
        for (activity in activityList) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_activity, parentLayout, false)
            val nameTextView = view.findViewById<TextView>(R.id.textViewActivityName)
            val descriptionTextView = view.findViewById<TextView>(R.id.textViewActivityDescription)

            nameTextView.text = activity.nama
            descriptionTextView.text = activity.deskripsi

            parentLayout.addView(view)
        }
    }
}
