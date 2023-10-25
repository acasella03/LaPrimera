package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Inicializa y modifica los datos de la app
 */
class MyViewModel() : ViewModel() {
    //para que sea mas facil la etiqueta del log
    private val TAG_LOG: String = "Mensaje ViewModel"

    // Utiliza la Data Class para mantener el estado de la aplicación
    var appState by mutableStateOf(AppState(emptyList(), 0, ""))

    //esta va a ser nuestra lista para la secuencia random
    //usamos mutable, ya que la queremos modificar y observar cuando cambia
    var _numbers = mutableStateOf(0)

    //crear una lista mutable
    val numbers= mutableStateListOf<Int>()

    // Dos maneras diferentes de definir un estado
    // con el = necesitamos utilizar value
    var counter=mutableStateOf(0)
    var name =mutableStateOf("")

    //inicializamos variables cuando instanciamos, éste es el constructor de la clase
    init {
        //se usa el log para saber cuando se ejecuta la instacia de la clase
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    /**
     * Crear entero random
     */
    fun crearRandom() {
        val randomNumber=(0..10).random()
        numbers.add(randomNumber)
        Log.d(TAG_LOG,"Creamos random $randomNumber")

        //Imprime la lista completa
        for(numero in numbers){
            Log.d(TAG_LOG,"Números aleatorio: $numero")
        }
        appState = appState.copy(numbers = numbers)
    }

    /**
     * Crear entero random
     */
    fun getNumero(): Int {
        return _numbers.value
    }

    fun getListaRandom(): List<Int> {
        return numbers.toList()
    }
    /**
     * Contador de clic
     */
    fun contadorClic(){
        appState = appState.copy(counter = appState.counter + 1)
    }

    /**
     * Crear contador
     */
    fun getContador():Int{
        return counter.value
    }

    /**
     * Obtener texto
     */
    fun getTexto():String{
        return name.value
    }

    fun setTexto(text: String) {
        appState = appState.copy(name = text)
    }
}