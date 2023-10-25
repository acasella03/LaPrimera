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
class MyViewModel : ViewModel() {
    private val TAG_LOG: String = "Mensaje ViewModel"

    // Utiliza la Data Class para mantener el estado de la aplicación
    var appState by mutableStateOf(AppState(emptyList(), 0, ""))

    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    fun crearRandom() {
        val randomNumber = (0..10).random()
        val newNumbers = appState.numbers.toMutableList()
        newNumbers.add(randomNumber)
        Log.d(TAG_LOG, "Creamos random $randomNumber")

        appState = appState.copy(numbers = newNumbers)
    }

    fun contadorClic() {
        appState = appState.copy(counter = appState.counter + 1)
    }

    fun setTexto(text: String) {
        appState = appState.copy(name = text)
    }
}