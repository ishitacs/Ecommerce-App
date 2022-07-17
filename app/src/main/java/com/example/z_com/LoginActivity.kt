package com.example.z_com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.z_com.Session.LoginPref
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var email: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var loginBtn: MaterialButton
    private lateinit var skipLogin: MaterialButton
    private lateinit var session: LoginPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        session = LoginPref(this)
        if (session.isLoggedIn()) {
            val i = Intent(applicationContext, ItemsActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
            finish()
        }
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.login)
        skipLogin = findViewById(R.id.skipLogin)

        loginBtn.setOnClickListener {
            val emailString = email.editText?.text.toString().trim()
            val passwordString = password.editText?.text.toString().trim()
            if (emailString.isEmpty() && passwordString.isEmpty()) {
                Toast.makeText(this, "Please enter Username and Password", Toast.LENGTH_LONG)
                    .show()
            } else if ((emailString == "Ishita" && passwordString == "Arora") || (emailString == "Himanshu" && passwordString == "Yadav") || (emailString == "Shubham" && passwordString == "Gupta") || (emailString == "Anirudh" && passwordString == "Aggarwal") || (emailString == "Soumya" && passwordString == "Sirohi")) {
                session.createLoginSession(emailString, passwordString)
                val i = Intent(applicationContext, ItemsActivity::class.java)
                startActivity(i)
                finish()
            } else {
                Toast.makeText(this, "Invalid username/password", Toast.LENGTH_LONG).show()
            }
        }
        skipLogin.setOnClickListener {
            val i = Intent(applicationContext, ItemsActivity::class.java)
            startActivity(i)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
    //clean code - call methods
    //scope function
    //extension fn
}