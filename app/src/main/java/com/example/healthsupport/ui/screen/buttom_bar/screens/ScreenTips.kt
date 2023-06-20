package com.example.healthsupport.ui.screen.buttom_bar.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.example.healthsupport.R



//Pantalla de los tips

data class CardData(val title: String, val description: String, val imageResource: Int)
val cardList = listOf(
    CardData(
        title = "Tensiometro",
        description = "colócalo en el brazo izquierdo, unos dos o tres dedos por encima del plexo. El mango, por tanto, debe quedar a la altura del corazón. " +
                "Debes estar sentado, con la espalda recta y sin moverte. Se aprieta el botón de “start” y esperas a que salgan los resultados." ,
        imageResource = R.drawable.tensiometro
    ),
    CardData(
        title = "Oxiometro",
        description = "Un oxímetro es un dispositivo médico con forma de pinza que ofrece datos de saturación de oxígeno en sangre con valores de 0 a 100. " +
                "Es habitual que el mismo aparato también incluya la opción de pulso cardiaco , indicando toda la información en una pequeña pantalla.",
        imageResource = R.drawable.oxiometro
    ),
    CardData(
        title = "Glucometro",
        description = "El glucometro es una herramienta que nos ayudara " +
                "para medir la glucosa del usuario",
        imageResource = R.drawable.glucometro
    )
)



@Composable
fun Tips() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp, 10.dp, 100.dp)
            .verticalScroll(scrollState)
    ) {
        cardList.forEachIndexed { index, cardData ->
            ExpandableCard(cardData = cardData, initiallyExpanded = index == 0)
        }
    }
}

@Composable
fun ExpandableCard(cardData: CardData, initiallyExpanded: Boolean) {
    var expanded by remember { mutableStateOf(initiallyExpanded) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { expanded = !expanded },
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = cardData.imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = cardData.title, style = MaterialTheme.typography.h6)
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = cardData.description, style = MaterialTheme.typography.body1)
            }
        }
    }
}

