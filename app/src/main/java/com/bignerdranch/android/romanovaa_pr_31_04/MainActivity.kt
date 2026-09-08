package com.bignerdranch.android.romanovaa_pr_31_04

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
     lateinit var registerButton: Button
     lateinit var loginText: EditText
     lateinit var  passwordText: EditText





    lateinit var preferences: SharedPreferences
    lateinit var ed: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun handler(view: View)
    {

        loginText = findViewById(R.id.login)
        passwordText = findViewById(R.id.password)

        preferences = getPreferences(MODE_PRIVATE)


        if (view.id ==  R.id.registerButton)
        {
            preferences = getPreferences(MODE_PRIVATE)

            var firstLaunch: Boolean = preferences.getBoolean("firstLaunch", true)
                ed = preferences.edit()


                if (loginText.text.toString() == "" || passwordText.text.toString() == "")
                {


                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Введите логин и пароль")
                        .setPositiveButton("OK",null)
                        .create()
                        .show()


                }
                else if (firstLaunch)
                {
                    ed.putString("login",loginText.text.toString())
                    ed.putString("password",passwordText.text.toString())

                    firstLaunch = false

                    ed.putBoolean("firstLaunch",firstLaunch)
                    ed.apply()

                    val intent = Intent(this,SecondActivity::class.java)
                    startActivity(intent)
                }
                else if (loginText.text.toString() == preferences.getString("login","").toString() && passwordText.text.toString() == preferences.getString("password","").toString())
                {
                    val intent = Intent(this,SecondActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Введите правильный логин и пароль")
                        .setPositiveButton("OK",null)
                        .create()
                        .show()
                }
            }


        }
    }




