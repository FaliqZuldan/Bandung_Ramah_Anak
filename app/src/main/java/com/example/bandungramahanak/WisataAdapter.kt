// WisataAdapter.kt
package com.example.bandungramahanak

import Data.Wisata
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class WisataAdapter(private val wisataList: List<Wisata>) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisata = wisataList[position]
        holder.bind(wisata)
    }

    override fun getItemCount(): Int = wisataList.size

    class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.textViewDescription)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val mapButton: Button = itemView.findViewById(R.id.buttonOpenMap)

        fun bind(wisata: Wisata) {
            nameTextView.text = wisata.nama
            descriptionTextView.text = wisata.deskripsi
            ratingBar.rating = wisata.rating

            mapButton.setOnClickListener {
                openMap(wisata.lokasi.latitude, wisata.lokasi.longitude)
            }
        }
        // Buka Map
        private fun openMap(latitude: Double, longitude: Double) {
            val uri = "geo:$latitude,$longitude"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            itemView.context.startActivity(intent)
        }
    }
}

