package com.dam.laprimera

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme

@Composable
fun InterfazUsuario(miViewModel: MyViewModel){
    //para que sea mas facil la etiqueta del log
    val TAG_LOG:String="Mensaje UI"

    //un cuadro de texto para mostrar los numeros
    Text(
        text="Numeros: ${miViewModel.appState.numbers}",
        modifier = Modifier
            .offset(y = 160.dp)
    )

    // un boton para generar numeros aleatorios
    Button(
        onClick = {
            Log.d(TAG_LOG,"Dentro del onClick")
            miViewModel.crearRandom()},
        modifier = Modifier
            .padding(vertical = 300.dp, horizontal = 100.dp) // Ajusta el espacio vertical según tus necesidades
            .offset(y=100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.monkey_emojis_4),
            contentDescription = "Generar numeros",
            modifier = Modifier
                .size(50.dp) // Ajusta el tamaño de la imagen según tus necesidades
                .padding(4.dp)
        )
        Text(text = "Generar numeros")
    }

    Login(miViewModel = MyViewModel())

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {
    Column {
        // mostrar el contador de clics
        TextButton(onClick = { miViewModel.contadorClic() }, modifier= Modifier.offset(y=5.dp)) {
            Text("CLICS: ${miViewModel.appState.counter}")
        }

        // mientras no tecleamos mas de tres caracteres no se muestra el saludo
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.appState.name}!",
                fontSize = 24.sp,
                modifier = Modifier.offset(y=110.dp)
            )
        }
        // campo de texto para rellenar
        OutlinedTextField(
            value = miViewModel.getTexto(),
            onValueChange = {
                miViewModel.name.value= it
            },
            label = { Text(text = "Name") }, modifier = Modifier.offset(y=5.dp)
        )

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        InterfazUsuario(miViewModel = MyViewModel())
    }
}