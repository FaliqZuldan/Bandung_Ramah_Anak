package Data

data class Wisata(
    val nama: String = "",
    val deskripsi: String = "",
    val lokasi: Location = Location(),
    val rating: Float = 0f
)

data class Location(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)

