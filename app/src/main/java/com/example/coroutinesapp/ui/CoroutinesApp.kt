package com.example.coroutinesapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.coroutinesapp.R
import com.example.coroutinesapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón para cambiar color
        Button(onClick = {
            changeColor = !changeColor
        },
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Blue else Color.Red
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }

        Spacer(modifier = modifier.height(30.dp))

        // Mostrar tiempos de los dos contadores
        Text(text = "Contador 1: ${viewModel.countTime1} [s]")
        Text(text = "Contador 2: ${viewModel.countTime2} [s]")
        Text(text = viewModel.resultState)

        Spacer(modifier = modifier.height(30.dp))

        // Botón para iniciar los contadores
        Button(onClick = {
            viewModel.startCounters()
        }) {
            Text(text = stringResource(id = R.string.realizar_consulta))
        }

        Spacer(modifier = modifier.height(30.dp))

        // Botón para cancelar los contadores
        Button(onClick = {
            viewModel.cancelCounters()
        }) {
            Text(text = "Cancelar Contadores")
        }
    }
}
