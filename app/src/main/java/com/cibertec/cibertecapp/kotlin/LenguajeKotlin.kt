package com.cibertec.cibertecapp.kotlin

fun main() {
   //1. Variables
    var miVariable: Int = 10
    val miConstante: Int = 20
    val pi: Double = 3.1416
    val piAlt = 3.1416  // Inferencia de Tipo - en Lenguajes fuertes (No recomendable)

    //2. Tipos de Datos
    val myInt: Int = 10
    val myLong: Long = 1200
    val myDouble: Double = 2.30
    val myFloat: Float = 12.5f
    val myBool: Boolean = true
    val myChar: Char = 'A'
    val myString: String = "Cibertec"

    print(myString)
    println(myChar)

    //Arreglos
    val myArray = arrayOf<Int>(20,15,10,20)     // Permite modificar los valores que tiene, no permite eliminar ni agregar
    val myArrayMix = arrayOf(1,'C',true)
    val myList = listOf(1,2,3)                  // No se puede modificar, solo lectura
    val myArrayList = arrayListOf(1,2)          // Permite añadir, eliminar y modificar los valores

    //Condicionales
    val aprobareCurso = true
    if (aprobareCurso){
        print("Aprenderé IOS")
    }else{
        print("Me gusta android")
    }

    //For
    val cursos = listOf("Android", "IOS")
    for(curso in cursos){
        print(curso)
    }

    for((index,value) in cursos.withIndex())
        print("$index $value")

    //While -- do While
    var contador = 0
    while(contador < cursos.size){
        print(cursos[contador])
        contador++
    }

    val maximo = 10
    var contador2 = 0
    do{
        print("Contador es: $contador2")
        contador2++
    }while (contador2 <=maximo)

    //When
    var mes: Int = 1
    when(mes){
        1 -> "Enero"
        2 -> "Febrero"
        else -> "Verifique datos"
    }

    //Operadores
    print(1+4)
    print(5-4)
    print(5*5)
    print(20/5)
    print(9%4)      // Modulo - Residuo


    val persona = Persona("Jose", "Li", 20, 12345678)
    persona.showData()
}

fun sumar(a:Int, b:Int): Unit{   //Unit como el Void
    print(a+b)
}

fun sumarReturn(a:Int, b:Int):Int{
    return a + b
}

//Clase es la estructura del objeto, el objeto es la instancia de la clase y puede contener datos
//En Kotlin hay 2 - constructor primario y secundario
//C. Primario
class Persona(val nombre:String, val apellidos:String, val edad:Int, val dni:Int){
    fun showData(){
        print("$nombre $apellidos")
    }
}
//C.Secundario
class Carro{
    var marca: String = ""
    var modelo: String = ""
    var color: String = ""
    constructor(marca:String, modelo: String, color:String){
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }
}
//Ambos Constructores
class Carro2(val anio: Int){
    var marca: String = ""
    var modelo: String = ""
    var color: String = ""
    constructor(marca:String, modelo: String, color:String, anio : Int) : this(anio){
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }
}


