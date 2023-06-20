package com.example.healthsupport.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthsupport.R
import com.example.healthsupport.ui.screen.buttom_bar.screens.Impresion
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel


@Composable
fun Registro(navController: NavHostController, viewModel: RegistroViewModel){

    Column(
        modifier = Modifier
            .padding()
            .background(color = Color.White)
    ) {


        Row() {

            TextButton(
                onClick = {
                    navController.navigate("Formulario")
                }, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Transparent
                )
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {


                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Añadir",
                        tint = Color.Black
                    )
                    Text(
                        text = "Nuevo Registro",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                }
            }
        }

        Impresion(viewModel = viewModel)



    }
}






