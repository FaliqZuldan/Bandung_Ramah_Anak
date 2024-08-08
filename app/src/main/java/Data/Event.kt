package Data

data class Event(
    val nama: String = "",
    val hari: String = "",
    val jam: String = "",
    val id: Long = 0L  // Ubah sesuai tipe data di Firebase
)
