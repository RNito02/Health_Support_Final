package com.example.healthsupport.ui.screen.buttom_bar.screens

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthsupport.ui.screen.persistence.DatabaseRegistro
import com.example.healthsupport.ui.screen.persistence.Registro
import com.example.healthsupport.ui.screen.repositories.RegistroRepositories

class RegistroViewModel(application: Application): ViewModel() {

    private val RegistroRepository: RegistroRepositories
    val allRegistro: LiveData<List<Registro>>

    init{
        val registroDB = DatabaseRegistro.getInstance(
            application.applicationContext)

        RegistroRepository = RegistroRepositories(registroDB.getDaoRegistro())
        allRegistro = RegistroRepository.allRegistro
    }

    fun createRegistro(registro: Registro){
        RegistroRepository.createRegistro(registro)
    }

    fun updateRegistro(registro: Registro){
        RegistroRepository.updateRegistro(registro)
    }

    fun deleteRegistro(registro: Registro){
        RegistroRepository.deleteRegistro(registro)
    }
}

class RegistroViewModelFactory(
    val application: Application
)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel>
            create(modelClass: Class<T>)
            : T {
        return RegistroViewModel(
            application = application) as T
    }
}