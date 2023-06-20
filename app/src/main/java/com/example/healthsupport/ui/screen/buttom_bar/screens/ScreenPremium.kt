package com.example.healthsupport.ui.screen.buttom_bar.screens
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.example.healthsupport.R



//Pantalla donde te redirecionara a la playstore
@Composable
fun Premium(){
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(),
        ) {

            Image(
                painter = painterResource(R.drawable.beneficios),
                contentDescription = "Mi imagen",
                modifier = Modifier
                    .size(500.dp)
                    .fillMaxSize()
                    .padding(16.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Gray)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Button(

                    onClick = {
                        val appPackageName = "com.microsoft.xboxone.smartglass" // Paquete de la Play Store
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(intent)
                        } catch (e: android.content.ActivityNotFoundException) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName"))
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(intent)
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        //.background(Color.Red)
                    ,shape = MaterialTheme.shapes.medium
                ) {
                    Text("Version Premium")
                }
            }
        }
    }
}








