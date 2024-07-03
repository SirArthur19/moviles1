package com.cibertec.cibertecapp.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.cibertec.cibertecapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng

class LugarMapFragment:Fragment(), OnMapReadyCallback {

    private var location: LatLng? = null
    private var nombre: String? = null
    private var descripcion: String? = null
    private var imagen: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmente_map_lugar,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val latitude = it.getDouble("latitude")
            val longitude = it.getDouble("longitude")
            location = LatLng(latitude, longitude)

            nombre = it.getString("nombre")
            descripcion = it.getString("descripcion")
            imagen = it.getString("imagen")
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
        val txtDescripcion = view.findViewById<TextView>(R.id.txtDescripcion)
        val imgLugar = view.findViewById<ImageView>(R.id.imgLugar)

        txtNombre.text = nombre
        txtDescripcion.text = descripcion
        imagen?.let {
            Glide.with(this)
                .load(it)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(imgLugar)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        location?.let {
            googleMap.addMarker(MarkerOptions().position(it).title("Ubicación"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 17f))
        }
    }

    companion object {
        fun newInstance(latitude: Double, longitude: Double,nombre: String, descripcion:String, imagen:String): LugarMapFragment {
            val fragment = LugarMapFragment()
            val args = Bundle()
            args.putDouble("latitude", latitude)
            args.putDouble("longitude", longitude)
            args.putString("nombre", nombre)
            args.putString("descripcion", descripcion)
            args.putString("imagen", imagen)
            fragment.arguments = args
            return fragment
        }
    }
}