package com.example.nequiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class Movimientos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos)
        val movimientos = GlobalData.movimientosLista;
        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        if(movimientos.isNotEmpty()){
            for (elemento in movimientos) {
                val textView = TextView(this)
                textView.text = GlobalData.movimientosAcciones[movimientos.indexOf(elemento)]+":      "+elemento;
                linearLayout.addView(textView)
            }
        }else{
            val sinMovimientos = findViewById<TextView>(R.id.sinMovimientos)
            sinMovimientos?.visibility = View.VISIBLE
        }

    }
}