package com.cibertec.cibertecapp.noticias

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NoticiasViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_noticia, viewGroup,false)) {
    private var imgNoticia: ImageView? = null
    private var titleNoticia: TextView? = null
    private var textNoticia: TextView? = null

    init{
        imgNoticia = itemView.findViewById(R.id.imgNoticia)
        titleNoticia = itemView.findViewById(R.id.titleNoticia)
        textNoticia = itemView.findViewById(R.id.textNoticia)
    }

    fun bind(noticia: Noticia){
        imgNoticia?.setImageResource(noticia.imagen)
        titleNoticia?.text = noticia.titulo
        textNoticia?.text = noticia.descripcion
    }
}