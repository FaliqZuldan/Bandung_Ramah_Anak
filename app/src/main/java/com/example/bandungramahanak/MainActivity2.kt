package com.example.bandungramahanak

import Data.Event
import Data.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var eventLinearLayout: LinearLayout
    private lateinit var activityLinearLayout: LinearLayout
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance("https://bandung-ramah-anak-bb75b-default-rtdb.asia-southeast1.firebasedatabase.app/").reference

        // Initialize LinearLayouts
        eventLinearLayout = findViewById(R.id.linearLayoutEvents)
        activityLinearLayout = findViewById(R.id.linearLayoutActivities)

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Handle back button click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Load data from Firebase
        loadEvents()
        loadActivities()
    }

    private fun loadEvents() {
        database.child("Event").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                eventLinearLayout.removeAllViews() // Clear existing views
                for (dataSnapshot in snapshot.children) {
                    val event = dataSnapshot.getValue(Event::class.java)
                    if (event != null) {
                        val eventView = LayoutInflater.from(this@MainActivity2)
                            .inflate(R.layout.item_event, eventLinearLayout, false)
                        val nameTextView: TextView = eventView.findViewById(R.id.textViewEventName)
                        val dayTextView: TextView = eventView.findViewById(R.id.textViewEventDay)
                        val timeTextView: TextView = eventView.findViewById(R.id.textViewEventTime)

                        // Set the text for each TextView
                        nameTextView.text = event.nama
                        dayTextView.text = event.hari
                        timeTextView.text = event.jam

                        // Add the event view to the linear layout
                        eventLinearLayout.addView(eventView)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle possible errors
            }
        })
    }

    private fun loadActivities() {
        database.child("Activity").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                activityLinearLayout.removeAllViews() // Clear existing views
                for (dataSnapshot in snapshot.children) {
                    val activity = dataSnapshot.getValue(Activity::class.java)
                    if (activity != null) {
                        val activityView = LayoutInflater.from(this@MainActivity2)
                            .inflate(R.layout.item_activity, activityLinearLayout, false)
                        val nameTextView: TextView = activityView.findViewById(R.id.textViewActivityName)
                        val descriptionTextView: TextView = activityView.findViewById(R.id.textViewActivityDescription)

                        // Set the text for each TextView
                        nameTextView.text = activity.nama
                        descriptionTextView.text = activity.deskripsi

                        // Add the activity view to the linear layout
                        activityLinearLayout.addView(activityView)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle possible errors
            }
        })
    }
}
