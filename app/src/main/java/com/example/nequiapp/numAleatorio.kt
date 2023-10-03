package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class numAleatorio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_aleatorio)
        val num1 = findViewById<TextView>(R.id.num1);
        val num2 = findViewById<TextView>(R.id.num2);
        val num3 = findViewById<TextView>(R.id.num3);
        val num4 = findViewById<TextView>(R.id.num4);
        val confirmarBtn = findViewById<Button>(R.id.retirarCodigo)
        val codigoSalir = findViewById<ImageButton>(R.id.codigoSalir)

        fun rand(start: Int, end: Int): Int {
            require(start <= end) { "Illegal Argument" }
            return (start..end).random()
        }

        num1.text = rand(0,9).toString()
        num2.text = rand(0,9).toString()
        num3.text = rand(0,9).toString()
        num4.text = rand(0,9).toString()
        val codigoGenerado = num1.text.toString()+num2.text.toString()+num3.text.toString()+num4.text.toString()
        GlobalData.codigoGenerado = codigoGenerado;
        confirmarBtn.setOnClickListener {
            val actividadPrincipal = Intent(this, Retirar::class.java)
            startActivity(actividadPrincipal)
        }
        codigoSalir.setOnClickListener {
            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
            startActivity(actividadPrincipal)
        }


    }
}