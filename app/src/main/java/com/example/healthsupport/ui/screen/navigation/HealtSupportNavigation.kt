package com.example.healthsupport.ui.screen.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.example.healthsupport.ui.screen.login.LoginScreenViewModel

import com.example.healthsupport.ui.screen.home.Home
import com.example.healthsupport.ui.screen.login.LoginScreen
import com.example.healthsupport.ui.screen.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterial3Api
@Composable
fun HealtSupportNavigation(viewModelo : RegistroViewModel){
    val navController = rememberNavController()
    val viewModel = LoginScreenViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.name
    ) {
        composable(Screen.SplashScreen.name){
            SplashScreen( navController = navController)
        }
        composable(Screen.LoginScreen.name){
            LoginScreen( viewModel = viewModel, navHost =navController )
        }
        composable(Screen.HomeScreen.name){
            Home( navController=navController, viewModel = viewModelo )
        }
    }
}