package com.cibertec.cibertecapp.notas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.cibertecapp.R

class DetailNotaActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_nota)

        val textFecha = findViewById<TextView>(R.id.textFecha)
        val textTitulo = findViewById<TextView>(R.id.textTitulo)
        val textContenido = findViewById<TextView>(R.id.textContenido)

        val intent = intent
        textFecha.text = intent.getStringExtra("fecha")
        textTitulo.text = intent.getStringExtra("titulo")
        textContenido.text = intent.getStringExtra("contenido")

    }
}