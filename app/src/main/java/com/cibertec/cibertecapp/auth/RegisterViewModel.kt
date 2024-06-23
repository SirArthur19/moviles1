package com.cibertec.cibertecapp.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel:ViewModel() {
    private lateinit var auth: FirebaseAuth
    val userRegisterStatus = MutableLiveData<Boolean>()

    fun verifyRegister(email:String, password:String){
        registerFirebase(email,password)
    }

    private fun registerFirebase(email: String,password: String){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                userRegisterStatus.value = it.isSuccessful
            }
    }
}