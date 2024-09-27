package com.example.coroutinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.coroutinesapp.ui.CoroutinesApp
import com.example.coroutinesapp.ui.theme.CoroutinesAppTheme
import com.example.coroutinesapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            CoroutinesAppTheme {
                CoroutinesApp(viewModel)
            }
        }
    }
}
