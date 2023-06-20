package com.example.healthsupport.ui.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.healthsupport.ui.screen.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import com.example.healthsupport.R

@Composable
fun SplashScreen(
    navController: NavController
){
    val scale = remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            ),
        )
        delay(3500L)
        if(FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(Screen.LoginScreen.name)
        }else{
            navController.navigate(Screen.HomeScreen.name){
                popUpTo(Screen.SplashScreen.name){
                    inclusive = true
                }
            }
        }
    }

    val color = MaterialTheme.colors.primary
    Surface(modifier = Modifier
        .padding(15.dp)
        .size(330.dp)
        .scale(scale.value),
        color = Color.White,
    ) {
        Column(modifier = Modifier
            .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(180.dp),painter = painterResource(id = R.drawable.latido) ,
                contentDescription = "Icono")

            Text("Healt Support",
                style = MaterialTheme.typography.h3,
                color = Color.DarkGray.copy(alpha = 0.5f,
                )
            )
        }
    }
}