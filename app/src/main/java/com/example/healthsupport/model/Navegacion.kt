package com.example.healthsupport.model

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.example.healthsupport.ui.screen.buttom_bar.screens.ScreenHome
import com.example.healthsupport.ui.screen.buttom_bar.screens.Tabs_principal
import com.example.healthsupport.ui.screen.persistence.Registro

@ExperimentalMaterial3Api
@Composable
fun NavigationRegistro(viewModelo : RegistroViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Registro"
    ){
        composable("Registro"){
            Registro(navController = navController, viewModel = viewModelo)
        }
        composable("Formulario"){
            Tabs_principal( navController = navController, viewModel = viewModelo)
        }
        composable("ScreenHome"){
           ScreenHome(viewModel = viewModelo, navController = navController)
        }
    }

}