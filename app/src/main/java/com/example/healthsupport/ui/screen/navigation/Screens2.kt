package com.example.healthsupport.ui.screen.navigation

sealed class Screens2(
    val url:String) {
    object ScreenHome:
        Screens2(url = "home")
    object AddRegistroScreen:
        Screens2(url = "add_registro")
}
