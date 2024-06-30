package com.cibertec.cibertecapp.news


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class NewsViewModel: ViewModel() {

    private lateinit var firestore: FirebaseFirestore
    val newsListMutable = MutableLiveData<List<News>>()
    var newsList  = arrayListOf<News>()

    fun getNews() {
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("noticias")
            .whereEqualTo("estado", true)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val id = document.id
                    val data = document.data

                    val titulo = data["titulo"] as String
                    val contenido = data["contenido"] as String
                    val fecha = data["fecha"] as String
                    val imagen = data["imagen"] as String
                    val estado = data["estado"] as Boolean

                    val news = News(contenido, estado, fecha, imagen, titulo)
                    newsList.add(news)

//                    Log.v("NOTICIAS FIRESTORE", id)
//                    Log.v("NOTICIAS FIRESTORE", titulo)
                }
                newsListMutable.value = newsList
            }
            .addOnFailureListener { exception ->

            }
    }

}