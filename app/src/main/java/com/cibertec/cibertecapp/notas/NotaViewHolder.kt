package com.cibertec.cibertecapp.notas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NotaViewHolder(inflater: LayoutInflater,parent:ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.item_nota,parent,false)),
    View.OnClickListener {
    private var textFecha: TextView? = null
    private var textTitulo: TextView? = null
    private var textContenido: TextView? = null
    private var nota: Nota? = null

    init {
        textFecha = itemView.findViewById(R.id.textFecha)
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textContenido = itemView.findViewById(R.id.textContenido)
        itemView.setOnClickListener(this)
    }

    fun data(nota: Nota){
        this.nota = nota
        textFecha?.text = nota.fecha
        textTitulo?.text = nota.titulo
        textContenido?.text = nota.contenido
    }

    override fun onClick(v: View?) {
        val context = itemView.context
        val intent = Intent(context, DetailNotaActivity::class.java)
        intent.putExtra("fecha", nota?.fecha)
        intent.putExtra("titulo", nota?.titulo)
        intent.putExtra("contenido", nota?.contenido)
        context.startActivity(intent)
    }
}