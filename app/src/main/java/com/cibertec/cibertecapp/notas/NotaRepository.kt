package com.cibertec.cibertecapp.notas

import android.app.Application
import androidx.lifecycle.LiveData
import com.cibertec.cibertecapp.database.CibertecDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotaRepository(application: Application) {

    private val notaDAO = CibertecDatabase.getInstance(application).notaDao()

    //LiveData es un contenedor de datos observables
    //notifica a la activity ante cualquier cambio
    fun getNotas() : LiveData<List<Nota>>{
        return notaDAO.list()
    }

    //que la función se puede suspender
    suspend fun insertNota(nota: Nota){
        withContext(Dispatchers.IO){
            notaDAO.insert(nota)
        }
    }
}