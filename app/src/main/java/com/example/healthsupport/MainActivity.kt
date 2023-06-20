package com.example.healthsupport

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModelFactory
import com.example.healthsupport.ui.screen.navigation.HealtSupportNavigation
import com.example.healthsupport.ui.screen.navigation.SetupNavGraph
import com.example.healthsupport.ui.theme.HealthSupportTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val owner =
            LocalViewModelStoreOwner.current
            val navHost = rememberNavController()

            Surface(
                modifier = Modifier
                    .padding()
                    .background(color = Color.White)

            ) {
                      HealthSupportTheme() {
                    owner?.let{
                        val viewModel: RegistroViewModel =
                            viewModel(
                                it,
                                "RegistroViewModel",
                                RegistroViewModelFactory(
                                    application = this.application)
                            )
                        SaludRemote(viewModelo = viewModel)
                    }
                }
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SaludRemote(viewModelo: RegistroViewModel) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HealtSupportNavigation(viewModelo = viewModelo)
            }
        }
    }
}

