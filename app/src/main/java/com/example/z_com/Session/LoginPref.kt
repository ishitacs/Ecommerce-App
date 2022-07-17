package com.example.z_com.Session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.z_com.LoginActivity

class LoginPref {
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var context : Context
    var PRIVATEMODE: Int = 0

    constructor(context: Context){
        this.context = context
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATEMODE)
        editor = preferences.edit()
    }

    companion object{
        val PREF_NAME = "Login_Preference"
        val IS_LOGIN = "isLoggedIn"
        val KEY_USERNAME = "username"
        val KEY_PASSWORD = "password"

    }

    fun createLoginSession(username:String, password:String){
        editor.putBoolean(IS_LOGIN,true)
        editor.putString(KEY_USERNAME,username)
        editor.putString(KEY_PASSWORD,password)
        editor.commit()
    }
    fun checkLogin(){
        if(!this.isLoggedIn()){
            var i : Intent = Intent(context, LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    fun getUserDetails() : HashMap<String,String>{
        var user : Map<String,String> = HashMap<String,String>()
        (user as HashMap).put(KEY_USERNAME, preferences.getString(KEY_USERNAME,null)!!)
        (user as HashMap).put(KEY_PASSWORD, preferences.getString(KEY_PASSWORD,null)!!)
   return user
    }
    fun LogoutUser()
    {
     editor.clear()
     editor.commit()
        var i : Intent = Intent(context, LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(i)
    }

    fun isLoggedIn():Boolean{
        return preferences.getBoolean(IS_LOGIN,false)

    }

}