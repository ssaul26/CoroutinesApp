package com.example.coroutinesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var resultState by mutableStateOf("")
        private set

    var countTime1 by mutableStateOf(0)
        private set

    var countTime2 by mutableStateOf(0)
        private set

    private var job: Job? = null

    // Contador 1
    private suspend fun startFirstCounter() {
        for (i in 1..5) {
            delay(1000)  // Simula el delay de 1 segundo por cada ciclo
            countTime1 = i
        }
    }

    // Contador 2 (solo empieza cuando el primero finaliza)
    private suspend fun startSecondCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime2 = i
        }
    }

    // Función para ejecutar ambos contadores secuencialmente
    fun startCounters() {
        job = viewModelScope.launch {
            startFirstCounter()  // Primero ejecuta el contador 1
            startSecondCounter()  // Luego ejecuta el contador 2
            resultState = "Contadores completados"
        }
    }

    // Función para cancelar ambos contadores
    fun cancelCounters() {
        job?.cancel()
        resultState = "Contadores cancelados"
    }
}
