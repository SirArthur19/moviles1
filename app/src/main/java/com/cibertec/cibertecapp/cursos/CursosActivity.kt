package com.cibertec.cibertecapp.cursos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class CursosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val recyclerCursos = findViewById<RecyclerView>(R.id.recyclerCursos)

        val listCurso = listOf<Curso>(
            Curso("Curso de Android", R.drawable.logo_android),
            Curso("Curso de Assembly", R.drawable.logo_asm),
            Curso("Curso de IOS", R.drawable.logo_ios),
            Curso("Curso de SQL", R.drawable.logo_sql),
            Curso("Curso de Swift", R.drawable.logo_swift),
            Curso("Curso de Java", R.drawable.logo_java)
        )

        val adapter = CursosAdapter(listCurso)
        recyclerCursos.adapter = adapter
        recyclerCursos.layoutManager = LinearLayoutManager(this)
    }
}