// WisataFragment.kt
package com.example.bandungramahanak

import Data.Wisata
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class WisataFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WisataAdapter
    private val wisataList = mutableListOf<Wisata>()
    private val filteredWisataList = mutableListOf<Wisata>() // Untuk menyimpan hasil filter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wisata2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = WisataAdapter(filteredWisataList) // Gunakan filteredWisataList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val database = FirebaseDatabase.getInstance("https://bandung-ramah-anak-bb75b-default-rtdb.asia-southeast1.firebasedatabase.app").reference.child("Wisata")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                wisataList.clear()
                for (dataSnapshot in snapshot.children) {
                    val wisata = dataSnapshot.getValue(Wisata::class.java)
                    if (wisata != null) {
                        wisataList.add(wisata)
                    }
                }
                filterWisata("") // Tampilkan semua data saat pertama kali
            }

            override fun onCancelled(error: DatabaseError) {
                // Tangani error di sini
            }
        })
    }

    fun filterWisata(query: String) {
        val lowerCaseQuery = query.lowercase()
        filteredWisataList.clear()
        if (lowerCaseQuery.isEmpty()) {
            filteredWisataList.addAll(wisataList)
        } else {
            for (wisata in wisataList) {
                if (wisata.nama.lowercase().contains(lowerCaseQuery) ||
                    wisata.deskripsi.lowercase().contains(lowerCaseQuery)) {
                    filteredWisataList.add(wisata)
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}
