package com.bignerdranch.android.romanovaa_pr_31_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var result : TextView = findViewById<EditText>(R.id.result)
        var shape : TextView = findViewById<EditText>(R.id.shapeName)

        var intent : Intent = intent

        result.text = intent.getStringExtra("result")
        shape.text = intent.getStringExtra("shape")
    }

    fun handler(view: View)
    {
        if (view.id == R.id.backBtn)
        {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}