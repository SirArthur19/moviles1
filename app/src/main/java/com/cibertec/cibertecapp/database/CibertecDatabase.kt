package com.cibertec.cibertecapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cibertec.cibertecapp.notas.Nota
import com.cibertec.cibertecapp.notas.NotaDAO

//clase abstracta define métodos
//no deja ser instanciada
//lo que hace una clase + una interface, solo que no permite instanciar
@Database(entities = [Nota::class], version = 1)
abstract class CibertecDatabase:RoomDatabase() {
    abstract fun notaDao(): NotaDAO

    companion object{
        private const val DATABASE_NAME  = "cibertec_database"

        //Volatile tiene que ver con la arquitectura del procesador
        //de como procesa los datos, directo a la memoria
        @Volatile
        private var INSTANCE: CibertecDatabase? = null

        fun getInstance(context: Context): CibertecDatabase{
            return INSTANCE?: synchronized(this){
                INSTANCE?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context): CibertecDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                CibertecDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

    }
}