package com.example.healthsupport.ui.screen.buttom_bar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthsupport.ui.screen.buttom_bar.screens.Premium
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.example.healthsupport.ui.screen.buttom_bar.screens.ScreenHome
import com.example.healthsupport.ui.screen.buttom_bar.screens.Tabs_principal
import com.example.healthsupport.ui.screen.buttom_bar.screens.Tips
import com.example.healthsupport.ui.screen.splash.SplashScreen


//Navegacion inferior
@ExperimentalMaterial3Api
@Composable
fun NavigationHost( navController: NavHostController, viewModel: RegistroViewModel){
    NavHost(
        navController = navController,
        startDestination = Items_menu.Pantalla1.ruta,

    ){
        composable(Items_menu.Pantalla1.ruta){
            ScreenHome(navController = navController, viewModel = viewModel)

        }
        composable(Items_menu.Pantalla2.ruta){
            Tips()
        }
        composable(Items_menu.Pantalla3.ruta){
            Premium()
        }
        composable("pantalla_tabs"){
            Tabs_principal(navController = navController, viewModel = viewModel)
        }
        composable("splash"){
            SplashScreen(navController = navController )
        }
    }
}