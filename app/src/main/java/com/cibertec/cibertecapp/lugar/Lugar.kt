package com.cibertec.cibertecapp.lugar

import com.google.firebase.firestore.GeoPoint
import java.io.Serializable

data class Lugar(
    val nombre: String,
    val costo: String,
    val disponibilidad: String,
    val imagen: String,
    val descripcion: String,
    val ubicacion: GeoPoint
)
