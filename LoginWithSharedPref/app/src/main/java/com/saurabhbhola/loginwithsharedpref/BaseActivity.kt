package com.saurabhbhola.loginwithsharedpref

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PreferenceHelper.init(this)



        if(PreferenceHelper.isLogin){
            val intent = Intent(this, UserData::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(intent)

        }else{
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(intent)

        }


    }
}