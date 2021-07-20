package com.saurabhbhola.loginwithsharedpref

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.userdata.*

class UserData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userdata)

        if(PreferenceHelper.isLogin){
            inuserid.text = PreferenceHelper.username
            logout.setOnClickListener(){
                PreferenceHelper.isLogin = false
                Toast.makeText(this, "Logout Successful",Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                finish()
                startActivity(intent)
            }
        }else{
            Toast.makeText(this, "Couldn't Login Error Occurred", Toast.LENGTH_SHORT).show()
        }


    }
}