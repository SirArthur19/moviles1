package com.cibertec.cibertecapp.producto

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class ProductoViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_producto,viewGroup,false)) {
    private var discount: TextView? = null
    private var imageItem: ImageView? = null
    private var marca: TextView? = null
    private var nombre: TextView? = null
    private var costoFinal: TextView? = null
    private var costoInicial: TextView? = null

    init {
        discount = itemView.findViewById(R.id.discount)
        imageItem = itemView.findViewById(R.id.imageItem)
        marca = itemView.findViewById(R.id.marca)
        nombre = itemView.findViewById(R.id.nombre)
        costoFinal = itemView.findViewById(R.id.costoFinal)
        costoInicial = itemView.findViewById(R.id.costoInicial)
    }

    fun bind(producto: Producto){
        discount?.text = producto.descuento
        imageItem?.setImageResource(producto.imagen)
        marca?.text = producto.marca
        nombre?.text = producto.titulo
        costoFinal?.text = producto.precio2
        costoInicial?.text = producto.precio1
    }

}