package com.example.healthsupport.ui.screen.buttom_bar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.healthsupport.ui.screen.persistence.Registro
import androidx.compose.material.OutlinedTextField




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAddRegistro(
    navHost: NavHostController,
    viewModel: RegistroViewModel,


)
{
    var title by remember { mutableStateOf("")}
    var presion by remember { mutableStateOf("")}
    var glucosa by remember { mutableStateOf("")}
    var fecha by remember { mutableStateOf("")}




    Scaffold(
        topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                title = { Text(text = "Formulario", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = {
                        navHost.navigate(
                            "ScreenHome"
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
        Surface(modifier = Modifier.padding(it), color= Color.White) {
            Column(

                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
            ) {
                OutlinedTextField(
                    label = { Text("Fecha")}
                    ,value = title,
                    onValueChange = { value ->  title = value },
                    modifier =  Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    label = { Text("Presion") },
                    value = presion,
                    onValueChange = { value ->  presion = value},
                    modifier =  Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    label = { Text("Glucosa") },
                    value = glucosa,
                    onValueChange = { value ->  glucosa = value},
                    modifier =  Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    label = { Text("Hora") },
                    value = fecha,
                    onValueChange = { value ->  fecha = value},
                    modifier =  Modifier.fillMaxWidth()
                )


                Button(
                    onClick = {
                        val registro:Registro = Registro(
                            id = 0,
                            title = title,
                            presion = presion,
                            glucosa = glucosa,
                            fecha = fecha,
                            isCompleted = false
                        )
                        viewModel.createRegistro(registro)
                        //Regresa a Home
                        navHost.navigate( "Registro"
                        )
                    },
                    enabled = title.isNotEmpty() &&
                              presion.isNotEmpty() &&
                              glucosa.isNotEmpty() &&
                              fecha.isNotEmpty(),
                    modifier =  Modifier.padding(vertical= 8.dp)
                ) {
                    Text("Añadir")
                }

            }
        }
    }
}

