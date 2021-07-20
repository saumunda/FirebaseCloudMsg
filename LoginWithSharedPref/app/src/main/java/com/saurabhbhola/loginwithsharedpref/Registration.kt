package com.saurabhbhola.loginwithsharedpref

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registration.*

class Registration: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        PreferenceHelper.init(this)

        login.setOnClickListener(){
            Toast.makeText(this, "Login Here",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        btnRegister.setOnClickListener(){
//            if (PreferenceHelper.isRegistration) {
//                PreferenceHelper.isRegistration = false
//                PreferenceHelper.username = ""
//                PreferenceHelper.password = ""
//            } else {
//                val username = etUsername.text.toString()
//                val password = etPassword.text.toString()
//                if (username.isNotBlank() && password.isNotBlank()) {
//                    PreferenceHelper.isRegistration = true
//                    PreferenceHelper.username = username
//                    PreferenceHelper.password = password
//                    Toast.makeText(this, "Registration Successful, Now Login",Toast.LENGTH_LONG).show()
//
//                    val intent2 = Intent(this, MainActivity::class.java)
//                    startActivity(intent2)
//                } else {
//                    Toast.makeText(this, "Fill all Values", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        }

    }


}