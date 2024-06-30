package com.cibertec.cibertecapp.map

import android.graphics.Camera
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import java.util.Locale

class MapFragment: Fragment(), OnMapReadyCallback {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var map:GoogleMap
    private lateinit var centerMarker : ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //en una actividad es el supportFragmentManager no el child
        val fragmentMap = childFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        fragmentMap.getMapAsync(this)

//        centerMarker = view.findViewById(R.id.imgCenterMarker)
    }

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    //Todo lo que se quiera hacer en el mapa es en el onMapReady
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(),R.raw.stylemap))

        val marker = LatLng(-8.123570691991093,-79.02320789679037)
//        val marker2 = LatLng(-8.122469355679517,-79.02236762460976)
//        map.addMarker(
//            MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker02))
//                .position(marker)
//                .title("By Pass Ovalo Grau")
//        )
//        map.addMarker(
//            MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker02))
//                .position(marker2)
//                .title("Pollito")
//        )

        map.animateCamera(
            //mientras más alto el valor más se acerca
            CameraUpdateFactory.newLatLngZoom(marker,17f)
        )

        map.setOnMapClickListener {
            map.clear()
            map.addMarker(MarkerOptions().position(it))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(it,15f))
            getStreetName(it.latitude,it.longitude)
        }

//        map.setOnCameraIdleListener {
//            map.clear()
//            val centerLanLon = map.cameraPosition.target
//            val lat = centerLanLon.latitude
//            val lon = centerLanLon.longitude
//            getStreetName(lat, lon)
//        }

    }

    //Nuevos Marcadores FireStore
    fun getMarkers(){
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("lugares")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    val id = document.id
                    val data = document.data

                    val posicion = data["posicion"] as GeoPoint
                    posicion.latitude
                    posicion.longitude
                }
            }
    }
    private fun getStreetName(lat:Double,lon: Double){
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        try {
            val address = geocoder.getFromLocation(lat,lon,1)
            if(address != null && address.isNotEmpty()){
                val addressPosition = address[0]
                val addressName = addressPosition.getAddressLine(0)
                Toast.makeText(context,addressName,Toast.LENGTH_SHORT).show()
            }else{
                //Calle no encontrada
            }
        } catch (e:Exception){
            e.printStackTrace()
        }
    }
}