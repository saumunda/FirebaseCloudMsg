package com.saurabhbhola.loginwithsharedpref

import android.content.ContentProviderOperation
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object PreferenceHelper {
    private const val NAME ="AntierSolutions"
    private const val MODE =Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences varible
    private val IS_LOGIN = Pair("is_login", false)
 //   private val IS_REGISTERED = Pair("is_registered", false)
    private val USERNAME = Pair("username", "")
    private val PASSWORD = Pair("password", "")

    fun init(context: Context){
        preferences =context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit)

    {
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    //SharedPrefrences varibles getters/setters
    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
        set(value) = preferences.edit{
            it.putBoolean(IS_LOGIN.first, value)
        }

//    var isRegistration: Boolean
//        get() = preferences.getBoolean(IS_REGISTERED.first, IS_REGISTERED.second)
//        set(value) = preferences.edit{
//            it.putBoolean(IS_REGISTERED.first, value)
//        }


    var username: String?
    get() = preferences.getString(USERNAME.first, USERNAME.second)
    set(value) = preferences.edit{
        it.putString(USERNAME.first, value)
    }

    var password: String?
        get() = preferences.getString(PASSWORD.first, PASSWORD.second)
        set(value) = preferences.edit{
            it.putString(PASSWORD.first, value)
        }






}