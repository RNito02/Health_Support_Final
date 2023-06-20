package com.example.healthsupport.ui.screen.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoRegistro {

    @Query("SELECT * FROM registro")
    fun getAllRegistro(): LiveData<List<Registro>>

    @Insert
    fun insert(vararg Registro: Registro)

    @Update
    fun update(vararg Registro: Registro)

    @Delete
    fun delete(Registro: Registro)
}