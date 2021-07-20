package com.saurabhbhola.loginwithsharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

val CUSTOM_PREF_NAME = "User_data"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PreferenceHelper.init(this)
    //    setupLoginLayout()
        sign_up.setOnClickListener(){
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        login_button.setOnClickListener{
            if (PreferenceHelper.isLogin){
                PreferenceHelper.isLogin = false
                PreferenceHelper.username = ""
                PreferenceHelper.password = ""
            }else{
                val username = inuserid.text.toString()
                val password = inPassword.text.toString()
                if (username.isNotBlank() && password.isNotBlank()){
                    PreferenceHelper.isLogin = true
                    PreferenceHelper.username = username
                    PreferenceHelper.password = password
                    Toast.makeText(this, "Login Successful",Toast.LENGTH_LONG).show()
                    val intent = Intent(this, UserData::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    finish()
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Fill all Values", Toast.LENGTH_SHORT).show()
                }
            }
     //       setupLoginLayout()
        }
        }


//    private fun setupLoginLayout() {
//        if(PreferenceHelper.isLogin){
//            textView2.text = getText(R.string.hello_user)
//            textView.text = PreferenceHelper.username
//            inuserid.visibility = GONE
//            inPassword.visibility = GONE
//            textView3.visibility = GONE
//            login_button.text = getString(R.string.logout)
//            sign_up.visibility = GONE
//        }else{
//            textView2.text = getText(R.string.login_with_shared_prefrences)
//            //textView.text = PreferenceHelper.username
//            inuserid.visibility = VISIBLE
//            inPassword.visibility = VISIBLE
//            textView3.visibility = VISIBLE
//            textView.text = getText(R.string.username)
//            login_button.text = getString(R.string.login)
//            sign_up.visibility = VISIBLE
//
//
//        }
//
//    }



}

