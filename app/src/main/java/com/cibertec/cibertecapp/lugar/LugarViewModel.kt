package com.cibertec.cibertecapp.lugar

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint

class LugarViewModel: ViewModel() {

    private lateinit var firestore: FirebaseFirestore
    val lugarListMutable = MutableLiveData<List<Lugar>>()
    var lugarList  = arrayListOf<Lugar>()

    fun getLugar() {
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("places")
            .get()
            .addOnSuccessListener { result ->
                lugarList.clear()
                for (document in result) {
                    val id = document.id
                    val data = document.data

                    val costo = data["costo"] as String
                    val descripcion = data["descripcion"] as String
                    val disponibilidad = data["disponibilidad"] as String
                    val imagen = data["imagen"] as String
                    val nombre = data["nombre"] as String
                    val ubicacion = data["ubicacion"] as GeoPoint

                    val lugar = Lugar(nombre,costo,disponibilidad,imagen,descripcion, ubicacion)
                    lugarList.add(lugar)
                }
                lugarListMutable.value = lugarList
            }
            .addOnFailureListener { exception ->
                Log.e("LugarViewModel", "Error al obtener lugares", exception)
            }
    }
}