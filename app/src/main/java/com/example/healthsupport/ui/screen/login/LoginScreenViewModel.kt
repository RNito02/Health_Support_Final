package com.example.healthsupport.ui.screen.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

import com.example.healthsupport.model.User

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, home:() -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener{ task->
                        if(task.isSuccessful){
                            Log.d("Healt Support","Logeado con Google Exitoso!")
                            home()
                        }
                    }
                    .addOnFailureListener{
                        Log.d("Healt Support","Fallo al loguear con Google!")
                    }
            }catch (ex:Exception){
                Log.d("Healt Support", "Exception al loguear" +
                        ex.localizedMessage
                )
            }
        }


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener { authResult ->
                        Log.d("Healt Support","Logueado: ${authResult.toString()}")
                        home()
                    }
                    .addOnFailureListener{ ex->
                        Log.d("Healt Support", "Fallo al iniciar sesión: ${ex.localizedMessage}")
                    }
            } catch (ex: Exception) {
                Log.d("Healt Support", "signInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ){
        if(_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val displayName = task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        home()
                    }
                    else{
                        Log.d("Healt Support", "createUserWithEmailAndPassword:${task.result.toString()}")
                    }
                    _loading.value = false
                }
        }
    }
    private fun createUser(displayName: String?){
        val userId = auth.currentUser?.uid

        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            size = "155cms",
            weight = "75kg",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener { Log.d("Healt Support", "Creado ${it.id}")}
            .addOnFailureListener{ Log.d("Healt Support", "Ocurrio un error ${it}")}
    }
}