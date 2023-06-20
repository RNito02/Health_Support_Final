package com.example.healthsupport.ui.screen.repositories

import androidx.lifecycle.LiveData
import com.example.healthsupport.ui.screen.persistence.DaoRegistro
import com.example.healthsupport.ui.screen.persistence.Registro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroRepositories (private val daoRegistro: DaoRegistro) {

    private val coroutineScope =
        CoroutineScope(Dispatchers.Main)

    val allRegistro: LiveData<List<Registro>>
            = daoRegistro.getAllRegistro()

    fun createRegistro(registro: Registro){
        coroutineScope.launch(Dispatchers.IO) {
            daoRegistro.insert(registro)
        }
    }

    fun updateRegistro(registro: Registro){
        coroutineScope.launch(Dispatchers.IO) {
            daoRegistro.update(registro)
        }
    }

    fun deleteRegistro(registro: Registro){
        coroutineScope.launch(Dispatchers.IO) {
            daoRegistro.delete(registro)
        }
    }
}