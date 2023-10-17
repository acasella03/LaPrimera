package com.dam.laprimera

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme

val TAG: String = "Estado"
val NAME: String = "Android"


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializamos ViewModel
        val miViewModel:MyViewModel=MyViewModel()
        setContent {
            LaPrimeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    //Greeting(NAME)
                    InterfazUsuario(miViewModel)
                }

            }
        }
        Log.d(TAG, "onCreate")

        /*calcular(a = 3, b = 5, fun() {
            //val suma = numero1 + numero2
            //Log.d("calcular", suma.toString())
        })

        /*
        Esto es una función que ya tiene parámetros predefinidos 
        y una termina con función vacía como parámetro 
        
        fun calcular(a: Int = 0, b: Int = 0, operacion: () -> Unit) {
        operacion()
         */
        calcular {
            Log.d("calcular", "yo no hago nada, solo LOG")
        }*/
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    /*fun calcular(a: Int = 0, b: Int = 0, operacion: () -> Unit) {
        //val operacion = a + b
        //Log.d("calcular", operacion.toString())
        //operacion(a, b)
        operacion()
    }*/
}

// Declara tu función para generar números aleatorios
/*fun generarNumeroAleatorio(): Int {
    return (0..10).random()
}*/