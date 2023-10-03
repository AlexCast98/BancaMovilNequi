package com.example.nequiapp

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CodigoAcceso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_acceso)
        val saldoActual = GlobalData.saldo
        findViewById<TextView>(R.id.saldo).text= "$"+saldoActual;
        val retirar = findViewById<Button>(R.id.retirar)
        val enviar = findViewById<Button>(R.id.enviar)
        val servicios = findViewById<Button>(R.id.servicios)
        val recargar = findViewById<Button>(R.id.recargar)
        val movimientos = findViewById<ImageButton>(R.id.movimientos)

        enviar.setOnClickListener {
            val actividadEnviar = Intent(this, Enviar::class.java)
            startActivity(actividadEnviar)
        }
        retirar.setOnClickListener {
            val actividadRetirar = Intent(this, numAleatorio::class.java)
            startActivity(actividadRetirar)
        }
        servicios.setOnClickListener {
            val actividadServicios = Intent(this, Servicios::class.java)
            startActivity(actividadServicios)
        }
        recargar.setOnClickListener {
            val actividadRecargar = Intent(this, Recargar::class.java)
            startActivity(actividadRecargar)
        }
        movimientos.setOnClickListener {
            val actividadRecargar = Intent(this, Movimientos::class.java)
            startActivity(actividadRecargar)
        }


    }
}



