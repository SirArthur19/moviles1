package com.cibertec.cibertecapp.noticias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NoticiasActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val recyclerNoticia = findViewById<RecyclerView>(R.id.recyclerCursos)

        val listNoticia = listOf<Noticia>(
            Noticia(
                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
                R.drawable.news_01,
                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
            ),
            Noticia(
                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
                R.drawable.news_02,
                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
            ),
            Noticia(
                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
                R.drawable.news_03,
                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
            ),
            Noticia(
                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
                R.drawable.news_04,
                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
            ),
            Noticia(
                "SECTOR INMOBILIARIO EN PERÚ: ¿POR QUÉ EL DISEÑO DE INTERIORES ESTÁ GENERANDO OPORTUNIDADES Y SALARIOS ATRACTIVOS?",
                R.drawable.news_05,
                "En los últimos años, el sector inmobiliario se encuentra en expansión, según la Asociación de Empresas Inmobiliarios del Perú (ASEI), este sector mostró un incremento del 7% a inicios del 2024. Para Sandra Jara, coordinadora académica de la Facultad de Diseño de la Escuela de Educación Superior Cibertec, este panorama es favorable no solo para el desarrollo económico, sino también para el mercado laboral de profesionales técnicos en diseño de interiores."
            )
        )

        val adapter = NoticiasAdapter(listNoticia)
        recyclerNoticia.adapter = adapter
        recyclerNoticia.layoutManager = LinearLayoutManager(this)
    }

}