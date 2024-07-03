package com.cibertec.cibertecapp.lugar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.cibertecapp.R


class LugarViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_lugar, viewGroup,false)) {
    private var txtNombre: TextView? = null
    private var txtCosto: TextView? = null
    private var txtDisponibilidad: TextView? = null
    private var imgLugar: ImageView? = null
    private var txtDescripcion: TextView? = null
    private var btnUbicacion: Button? = null

    init {
        txtNombre = itemView.findViewById(R.id.txtNombre)
        txtCosto = itemView.findViewById(R.id.txtCosto)
        txtDisponibilidad = itemView.findViewById(R.id.txtDisponibilidad)
        imgLugar = itemView.findViewById(R.id.imgLugar)
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion)
        btnUbicacion = itemView.findViewById(R.id.btnUbicacion)
    }

    fun data(lugar: Lugar){
        txtNombre?.text = lugar.nombre
        txtCosto?.text = lugar.costo
        txtDisponibilidad?.text = lugar.disponibilidad
        txtDescripcion?.text = lugar.descripcion

        imgLugar?.let {
            Glide.with(it.context)
                .load(lugar.imagen)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(it)
        }

        btnUbicacion?.setOnClickListener {
            val latitude = lugar.ubicacion.latitude
            val longitude = lugar.ubicacion.longitude
            val nombre = lugar.nombre
            val descripcion = lugar.descripcion
            val imagen = lugar.imagen
            val fragment = LugarMapFragment.newInstance(latitude, longitude,nombre,descripcion,imagen)

            (itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu_lugar, fragment)
                .addToBackStack(null)
                .commit()
        }

    }
}