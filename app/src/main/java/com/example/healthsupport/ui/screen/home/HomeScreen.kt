package com.example.healthsupport.ui.screen.home

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.healthsupport.ui.screen.buttom_bar.Items_menu
import kotlinx.coroutines.CoroutineScope
import com.example.healthsupport.R
import com.example.healthsupport.ui.screen.buttom_bar.NavigationHost
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.unit.sp



//TopAppBar y Navegacion Inferior
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, viewModel: RegistroViewModel) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    val navigation_item = listOf(
        Items_menu.Pantalla1,
        Items_menu.Pantalla2,
        Items_menu.Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { NavegacionInferior(navController,navigation_item)},
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(10.dp),
                elevation = 0.dp,
                backgroundColor = Color.White,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .size(18.dp)
                        .padding(horizontal = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Box(
                        modifier = Modifier
                            .size(65.dp)
                            .clip(shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.latido),
                            contentDescription = " Profile picture",
                            contentScale = ContentScale.Fit
                        )
                    }
                    Text("Healt Support", fontSize = 18.sp)

                    //Button(onClick = { }) { }

                }
            }
        },
        floatingActionButton = {Fab(scope, scaffoldState, navController)},
        isFloatingActionButtonDocked = true
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationHost(navController, viewModel)
        }
    }
}


@Composable
fun currentRoute(navController: NavHostController): String?{
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(
    navController: NavHostController,
    menu_items: List<Items_menu>) {
    BottomAppBar(

        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        backgroundColor = Color.Red,
        elevation = 5.dp,
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        )
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,0.dp,60.dp,0.dp
            ),
            backgroundColor = Color.Red
        ) {
            val currentRoute = currentRoute(navController = navController)
            menu_items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = {navController.navigate(item.ruta)},
                    icon = {
                        Icon(
                            painter = painterResource(id = item.Icon),
                            contentDescription = item.title)
                    },
                    label = {Text(item.title)},
                    alwaysShowLabel = false
                )
            }
        }
    }
}

@Composable
fun Fab(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController) {

    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            auth.signOut()
            restartApplication(context)

        },
        backgroundColor = Color.Red
    )
    {
        Icon(imageVector = Icons.Filled.AccountBox,
            contentDescription = "Cierre de sesion")
    }
}

private fun restartApplication(context: Context) {
    val packageManager = context.packageManager
    val intent = packageManager.getLaunchIntentForPackage(context.packageName)
    intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    context.startActivity(intent)
}




