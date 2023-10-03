package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel )

        val button = findViewById<Button>(R.id.ingresar)
        val clave = findViewById<EditText>(R.id.codigo)
        button.setOnClickListener {
            val usuarioNumero = clave.text.toString()
            if (!(usuarioNumero.isNullOrEmpty() || usuarioNumero.length<4)) {
                val actividad3 = Intent(this, CodigoAcceso::class.java)
                startActivity(actividad3)

            } else {
                clave.setError("Este campo no puede ir vacio y debe ser de 4 digitos")
            }

        }
    }
}