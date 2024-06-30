package com.cibertec.cibertecapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.menu.MenuActivity

class RegisterActivity: AppCompatActivity() {

    private  lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        val name = findViewById<EditText>(R.id.edtNombre)
        val lastname = findViewById<EditText>(R.id.edtApellidos)
        val email = findViewById<EditText>(R.id.edtEmail)
        val password = findViewById<EditText>(R.id.edtPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener{
            val name = name.text.toString()
            val lastname = lastname.text.toString()
            val emailValue = email.text.toString()
            val passwordValue = password.text.toString()
            viewModel.verifyRegister(name,lastname,emailValue,passwordValue)
        }

        observerLiveData()
    }

    private fun observerLiveData(){
        viewModel.userRegisterStatus.observe(this){
            if (it){
                Toast.makeText(this,"Registro correcto", Toast.LENGTH_SHORT).show()
                //snackbar o alert en vez del toast
                finish()
            }else{
                Toast.makeText(this,"Verificar sus datos", Toast.LENGTH_SHORT).show()
            }

        }
    }



}