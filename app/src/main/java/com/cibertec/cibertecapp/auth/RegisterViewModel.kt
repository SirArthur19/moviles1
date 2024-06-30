package com.cibertec.cibertecapp.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel:ViewModel() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    val userRegisterStatus = MutableLiveData<Boolean>()

    fun verifyRegister(name: String, lastName:String ,email:String, password:String){
        registerFirebase(name, lastName, email, password)
    }

    private fun registerFirebase(name: String, lastName:String,email: String,password: String){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val uid = it.result.user?.uid

                    uid?.let {
                        registerFirestore(uid,name,lastName,email)
                    }
                }else{
                    userRegisterStatus.value = false
                }
            }
    }

    private fun registerFirestore(uid:String,name: String, lastName:String,email: String){
        firestore = FirebaseFirestore.getInstance()
        val user = hashMapOf(
            "name" to name,
            "lastName" to lastName,
            "email" to email,
            "uid" to uid
        )

        firestore.collection("usuarios").document(uid)
            .set(user)
            .addOnSuccessListener {
                userRegisterStatus.value = true
            }
            .addOnFailureListener {
                userRegisterStatus.value = false
            }
    }

}