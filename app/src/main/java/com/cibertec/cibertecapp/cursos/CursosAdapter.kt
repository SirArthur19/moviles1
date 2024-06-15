package com.cibertec.cibertecapp.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Clase Abstracta para que no pueda crear instancias, para que en su interior pueda crear métodos, no pueda crear objetos

class CursosAdapter(val list: List<Curso>): RecyclerView.Adapter<CursosViewHolder>() {

    //Instancia el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CursosViewHolder(inflater,parent)
    }

    //Indica el número de elementos a mostrar
    override fun getItemCount(): Int {
        return list.size
    }

    //Asignarle datos al ViewHolder
    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val curso = list[position]
        holder.bind(curso)
    }
}