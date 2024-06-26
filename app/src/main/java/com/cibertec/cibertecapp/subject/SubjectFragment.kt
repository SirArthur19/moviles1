package com.cibertec.cibertecapp.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.cursos.Curso
import com.cibertec.cibertecapp.cursos.CursosAdapter
import com.cibertec.cibertecapp.menu.MenuDrawerAction

class SubjectFragment:Fragment() {

    lateinit var interfaceMenu : MenuDrawerAction
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subject,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarSubject = view.findViewById<Toolbar>(R.id.toolbarSubject)
        val recyclerCursos = view.findViewById<RecyclerView>(R.id.recyclerCursos)
        toolbarSubject.setNavigationOnClickListener {
            interfaceMenu.openMenu()
        }

        val listCurso = listOf<Curso>(
            Curso("Curso de Android", R.drawable.logo_android),
            Curso("Curso de Assembly", R.drawable.logo_asm),
            Curso("Curso de IOS", R.drawable.logo_ios),
            Curso("Curso de SQL", R.drawable.logo_sql),
            Curso("Curso de Swift", R.drawable.logo_swift),
            Curso("Curso de Java", R.drawable.logo_java)
        )

        val adapter = CursosAdapter(listCurso)
        recyclerCursos.adapter = adapter
        recyclerCursos.layoutManager = GridLayoutManager(context,2)
    }

    companion object{
        fun newInstance() : SubjectFragment = SubjectFragment()
    }
}