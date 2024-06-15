package com.cibertec.cibertecapp.kotlin

class Empleado(val nombre: String, val apellidos: String, val edad: Int, val salario: Int, val cargo: String){
    fun calcularBonificacion():Double{
        return when(cargo){
            "practicante" -> salario * 0.05
            "desarrollador" -> salario * 0.15
            "diseñador" -> salario * 0.08
            "gerente general" -> salario * 0.25
            else -> 0.0
        }
    }
    fun generarInforme(): String {
        val bonificacion = calcularBonificacion()
        return """
            Nombre: $nombre $apellidos, Edad: $edad, Salario: $salario, Cargo: $cargo
            Bonificación: $bonificacion
        """
    }
}


fun main() {
    val empleado = Empleado("Jose", "Diaz Lopez", 30, 4000, "diseñador")
    println(empleado.generarInforme())
}