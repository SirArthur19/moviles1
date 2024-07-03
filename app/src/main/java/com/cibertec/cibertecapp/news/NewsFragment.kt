package com.cibertec.cibertecapp.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.auth.LoginViewModel
import com.cibertec.cibertecapp.menu.MenuDrawerAction
import com.cibertec.cibertecapp.noticias.Noticia
import com.cibertec.cibertecapp.noticias.NoticiasAdapter

class NewsFragment:Fragment() {

    lateinit var interfaceMenu : MenuDrawerAction
    private lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        val toolbarNews = view.findViewById<Toolbar>(R.id.toolbarNews)

        val recyclerNoticias = view.findViewById<RecyclerView>(R.id.recyclerNoticias)
        val adapter = NewsAdapter()
        recyclerNoticias.adapter = adapter
        recyclerNoticias.layoutManager = LinearLayoutManager(activity)

        toolbarNews.setNavigationOnClickListener {
            interfaceMenu.openMenu()
        }
        toolbarNews.inflateMenu(R.menu.menu_toolbar)
        toolbarNews.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.itemCompartir -> {
                    Toast.makeText(context,"Compartido",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemActualizar -> {
                    Toast.makeText(context,"Se actualizó con éxito",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        //List Mode
        viewModel.getNews()
        viewModel.newsListMutable.observe(viewLifecycleOwner) {

            if (it.isNotEmpty()) {
                //mostrar recyclerview
                //Log.v("CANTIDAD_DATOS", it.size.toString())
                adapter.setNews(it)
            }

        }


//        val listNoticia = listOf<Noticia>(
//            Noticia(
//                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
//                R.drawable.news_01,
//                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
//            ),
//            Noticia(
//                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
//                R.drawable.news_02,
//                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
//            ),
//            Noticia(
//                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
//                R.drawable.news_03,
//                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
//            ),
//            Noticia(
//                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
//                R.drawable.news_04,
//                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
//            ),
//            Noticia(
//                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
//                R.drawable.news_05,
//                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
//            )
//        )

//        val adapter = NoticiasAdapter(listNoticia)
//        recyclerNoticias.adapter = adapter
//        recyclerNoticias.layoutManager = LinearLayoutManager(context,
//            LinearLayoutManager.VERTICAL,false)
    }

    companion object{
        fun newInstance() : NewsFragment = NewsFragment()
    }

}