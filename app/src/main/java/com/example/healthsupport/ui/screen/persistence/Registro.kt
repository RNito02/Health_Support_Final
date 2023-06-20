package com.example.healthsupport.ui.screen.persistence

import androidx.navigation.NavController
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.healthsupport.ui.screen.buttom_bar.screens.RegistroViewModel

@Entity(tableName = "registro")
data class Registro(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val presion: String,
    val glucosa: String,
    val fecha:  String,
    @ColumnInfo(name = "is_completed") val isCompleted: Boolean
){

}