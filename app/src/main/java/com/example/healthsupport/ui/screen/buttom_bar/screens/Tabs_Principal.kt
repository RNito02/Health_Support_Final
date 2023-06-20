package com.example.healthsupport.ui.screen.buttom_bar.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.healthsupport.ui.screen.navigation.Screens2
import com.example.healthsupport.ui.screen.persistence.Registro



//Navegacion de la flecha dentro de la pantalla Registro
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Tabs_principal(navController: NavHostController, viewModel: RegistroViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Registro",color = Color.Black, textAlign = TextAlign.Center) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(
                            "Registro"
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize(),
        ) {
        }
    }
    Impresion(viewModel = viewModel)
    ScreenAddRegistro(viewModel = viewModel, navHost = navController)
}


