package com.example.nequiapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_ingreso)
        val usuario = findViewById<EditText>(R.id.usuario)
            button.setOnClickListener {
                val usuarioNumero = usuario.getText().toString()
                if (usuarioNumero.isNotEmpty()) {
                    if(!(usuarioNumero.length<10)){
                        val actividad2 = Intent(this, PanelActivity::class.java)
                        startActivity(actividad2)
                    }else{
                        usuario.setError("Ingresa un numero valido")
                    }

                } else {
                    usuario.setError("Este campo no puede ir vacio")
                }

            }
        }

    }
