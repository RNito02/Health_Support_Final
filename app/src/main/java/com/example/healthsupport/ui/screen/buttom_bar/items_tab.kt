package com.example.healthsupport.ui.screen.buttom_bar
import com.example.healthsupport.R

//Declaracion de la navegacion inferior
sealed class Items_menu(
    val Icon: Int,
    val title: String,
    val ruta: String
){
    object  Pantalla1: Items_menu(R.drawable.baseline_home_24,
        "Inicio", "pantalla1")
    object  Pantalla2: Items_menu(R.drawable.baseline_tips_and_updates_24,
        "Tips", "pantalla2")
    object Pantalla3: Items_menu(R.drawable.baseline_star_24,
        "Premium","pantalla3")
}
