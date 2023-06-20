package com.example.healthsupport.ui.screen.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.example.healthsupport.ui.screen.buttom_bar.screens.ScreenAddRegistro
import com.example.healthsupport.ui.screen.buttom_bar.screens.ScreenHome
import com.example.healthsupport.ui.screen.home.Home

@ExperimentalMaterial3Api
@Composable
fun SetupNavGraph(
    navHost: NavHostController,
    viewModel: RegistroViewModel
){
    NavHost(
        navController = navHost,
        startDestination = Screens2.ScreenHome.url
    ){
        composable(
            route = Screens2.AddRegistroScreen.url
        ){
            ScreenAddRegistro(
                navHost = navHost,
                viewModel = viewModel
            )
        }

    }
}