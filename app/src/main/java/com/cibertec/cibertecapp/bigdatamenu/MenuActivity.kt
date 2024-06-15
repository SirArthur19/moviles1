package com.cibertec.cibertecapp.bigdatamenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.favoritos.FavoritosFragment
import com.cibertec.cibertecapp.inicio.InicioFragment
import com.cibertec.cibertecapp.perfil.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_view = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        nav_view.setOnItemSelectedListener {
            when(it.itemId){
                R.id.inicio -> {
                    val fragment = InicioFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.favoritos -> {
                    val fragment = FavoritosFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.perfil -> {
                    val fragment = PerfilFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
        nav_view.selectedItemId = R.id.inicio
    }

    fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menuBigData,fragment)
        transaction.commit()
    }
}