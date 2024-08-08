package com.example.bandungramahanak

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Deklarasi Animasi
        val stb = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.stb)
        val ttb = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.ttb)

        val logoanim = findViewById<ImageView>(R.id.imageView)
        val card1 = findViewById<CardView>(R.id.card_view_1)
        val card2 = findViewById<CardView>(R.id.card_view_2)
        val card3 = findViewById<CardView>(R.id.card_view_3)


        //play animasi
        logoanim.startAnimation(stb)
        card1.startAnimation(ttb)
        card2.startAnimation(ttb)
        card3.startAnimation(ttb)


        val cardView1: CardView = findViewById(R.id.card_view_1)
        val cardView2: CardView = findViewById(R.id.card_view_2)
        val cardView3: CardView = findViewById(R.id.card_view_3)

        cardView1.setOnClickListener {
            val intent1 = Intent(this, MainActivity1::class.java)
            startActivity(intent1)
        }

        cardView2.setOnClickListener {
            val intent1 = Intent(this, MainActivity2::class.java)
            startActivity(intent1)
        }

        cardView3.setOnClickListener {
            val intent1 = Intent(this,MainActivity3::class.java)
            startActivity(intent1)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}