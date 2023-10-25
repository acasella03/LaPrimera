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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(miViewModel: MyViewModel) {
    val TAG_LOG: String = "Mensaje UI"

    Text(
        text = "Numeros: ${miViewModel.appState.numbers}",
        modifier = Modifier.offset(y = 200.dp)
    )

    Button(
        onClick = {
            Log.d(TAG_LOG, "Dentro del onClick")
            miViewModel.crearRandom()
        },
        modifier = Modifier
            .padding(vertical = 300.dp, horizontal = 100.dp)
            .offset(y = 100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.monkey_emojis_4),
            contentDescription = "Generar numeros",
            modifier = Modifier
                .size(50.dp)
                .padding(4.dp)
        )
        Text(text = "Generar numeros")
    }

    Column {
        TextButton(onClick = { miViewModel.contadorClic() }, modifier = Modifier.offset(y = 5.dp)) {
            Text("CLICS: ${miViewModel.appState.counter}")
        }

        if (miViewModel.appState.name.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.appState.name}!",
                fontSize = 24.sp,
                modifier = Modifier.offset(y = 110.dp)
            )
        }

        OutlinedTextField(
            value = miViewModel.appState.name,
            onValueChange = { miViewModel.setTexto(it) },
            label = { Text(text = "Name") },
            modifier = Modifier.offset(y = 5.dp)
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