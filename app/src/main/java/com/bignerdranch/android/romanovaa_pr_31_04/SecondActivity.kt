package com.bignerdranch.android.romanovaa_pr_31_04

import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import android.os.Bundle
import android.telephony.mbms.MbmsErrors
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


class SecondActivity : AppCompatActivity() {
    lateinit var calcButton: Button

    lateinit var image: ImageView

    lateinit var shape: Spinner

    lateinit var shapeSelected : String

    lateinit var  equation: EditText
    lateinit var  equation1: EditText
    lateinit var  equation2: EditText

    lateinit var preferences: SharedPreferences
    lateinit var ed: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        image = findViewById<ImageView>(R.id.circle)

        equation = findViewById<EditText>(R.id.equation)
        equation1 = findViewById<EditText>(R.id.equation1)
        equation2 = findViewById<EditText>(R.id.equation2)

        shape = findViewById<Spinner>(R.id.spinner)
        val items = arrayOf("Круг", "Треугольник")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        shape.adapter = adapter

        shape.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
        {
            shapeSelected = shape.selectedItem.toString()
            if (shapeSelected == "Круг")
            {
                image.setImageResource(R.drawable.circle)

                try {
                equation.visibility = View.VISIBLE
                equation1.visibility = View.GONE
                equation2.visibility = View.GONE
                }
                catch(e: Exception)
                {

                }
            }
            else if (shapeSelected == "Треугольник")
            {
                image.setImageResource(R.drawable.perim_treug2)

                try {
                equation.visibility = View.INVISIBLE
                equation1.visibility = View.VISIBLE
                equation2.visibility = View.VISIBLE
                }
                catch(e: Exception)
                {

                }
            }
        }

    }

    }

    fun handler(view: View)
    {

        equation = findViewById(R.id.equation)
        equation1 = findViewById(R.id.equation1)
        equation2 = findViewById(R.id.equation2)



        if (view.id ==  R.id.equationButton)
        {
            if (shape.selectedItem.toString() == "Круг")
            {
                if (equation.text.toString() != "")
                {
                    try {
                        val result = (equation.text.toString().toFloat() / (2 * kotlin.math.PI)).toString()
                        val intent = Intent(this, ThirdActivity::class.java)

                        intent.putExtra("result", result)
                        intent.putExtra("shape", shapeSelected)
                        startActivity(intent)
                    } catch (e: NumberFormatException) {
                        val alert = AlertDialog.Builder(this)
                            .setTitle("Ошибка")
                            .setMessage("Введите корректные данные")
                            .setPositiveButton("OK", null)
                            .create()
                            .show()
                    }
                }
                else
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Введите данные")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()
                }



            }
            else if (shape.selectedItem.toString() == "Треугольник")
            {
                if (equation1.text.toString() != "" || equation2.text.toString() != "")
                {
                    try {
                        val result = (equation1.text.toString().toFloat() * 2 + equation2.text.toString().toFloat()).toString()
                        val intent = Intent(this,ThirdActivity::class.java)

                        intent.putExtra("result",result)
                        intent.putExtra("shape",shapeSelected)
                        startActivity(intent)
                    }
                    catch (e: NumberFormatException)
                    {
                        val alert = AlertDialog.Builder(this)
                            .setTitle("Ошибка")
                            .setMessage("Введите корректные данные")
                            .setPositiveButton("OK",null)
                            .create()
                            .show()
                    }


                }
                else
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Введите данные")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()
                }
            }



        }


    }
}
