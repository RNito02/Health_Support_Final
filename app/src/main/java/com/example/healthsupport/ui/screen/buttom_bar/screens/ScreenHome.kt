package com.example.healthsupport.ui.screen.buttom_bar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LockClock
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthsupport.R
import com.example.healthsupport.model.NavigationRegistro
import com.example.healthsupport.ui.screen.navigation.Screens2
import com.example.healthsupport.ui.screen.persistence.Registro
import com.example.healthsupport.ui.theme.HealthSupportTheme



//Pantalla Principal
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(viewModel : RegistroViewModel ,navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NavigationRegistro(viewModel)
    }

}

@Composable
fun Impresion(
    viewModel: RegistroViewModel) {
    val listTask: List<Registro> by
    viewModel.allRegistro.observeAsState(listOf())

        LazyColumn(modifier =
        Modifier
            .padding()
            .fillMaxSize()){
            items(listTask){ item ->
                ItemTask(item, viewModel)
            }
        }
}

@Composable
fun ItemTask(item: Registro, viewModel: RegistroViewModel,){
    Card(

        modifier = Modifier
            .padding(
                20.dp, 20.dp, 20.dp, 20.dp
            )
            .fillMaxWidth()
            .background(color = Color.White),
        backgroundColor = Color.LightGray

    ){
        Column {


            Row() {
                Icon(
                    imageVector = Icons.Outlined.CalendarToday,
                    contentDescription = "Calendario"
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Fecha : " + item.title,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
            }

            Row() {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Informacion de la glucosa"
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Glucosa: " + item.glucosa,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
            }

            Row() {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Informacion de la glucosa"
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Presion: " + item.presion,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Row() {
                Icon(
                    imageVector = Icons.Outlined.LockClock,
                    contentDescription = "Hora del registro"
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "A la hora: " + item.fecha,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth()
                ,onClick = {
                    viewModel.deleteRegistro(item)

                }) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "ELiminar",
                    tint = Color.Black

                )
            }


        }
    }
}