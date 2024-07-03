package com.cibertec.cibertecapp.lugar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R

class MenuActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_lugar)

        if (savedInstanceState == null) {
            val fragment = LugarFragment.newInstance()
            openFragment(fragment)
        }
    }

    fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menu_lugar,fragment)
        transaction.commit()
    }
}