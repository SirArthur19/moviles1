package com.cibertec.cibertecapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.noticias.Noticia

class NewsViewHolder (inflater: LayoutInflater, viewGroup: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_noticia, viewGroup,false)) {
    private var imgNoticia: ImageView? = null
    private var titleNoticia: TextView? = null
    private var textNoticia: TextView? = null

    init{
        imgNoticia = itemView.findViewById(R.id.imgNoticia)
        titleNoticia = itemView.findViewById(R.id.titleNoticia)
        textNoticia = itemView.findViewById(R.id.textNoticia)
    }

    fun data(news: News){
        titleNoticia?.text = news.titulo
        textNoticia?.text = news.contenido

        imgNoticia?.let {
            Glide.with(it)
                .load(news.imagen)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(it)
        }
    }
}