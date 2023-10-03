package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Recargar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recargar)
        val cantidad = findViewById<EditText>(R.id.cantidadRecargar)
        val botonRetirar = findViewById<Button>(R.id.recargar)
        val salirRecargar = findViewById<ImageButton>(R.id.salirRecargar)
        botonRetirar.setOnClickListener{
            if(!(cantidad.text.toString().isNullOrEmpty())){
                val cantidadValue = cantidad.text.toString().toInt()
                if(cantidadValue>100){
                    GlobalData.saldo += cantidadValue;
                    GlobalData.movimientosLista.add(cantidadValue.toString())
                    GlobalData.movimientosAcciones.add("Recarga")
                    Toast.makeText(this, "Recarga exitosa", Toast.LENGTH_LONG).show()
                    val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                    startActivity(actividadPrincipal)

                }else{
                    Toast.makeText(this,"El minimo de recarga es de 100 pesos", Toast.LENGTH_LONG).show()

                }
            }

        }
        salirRecargar.setOnClickListener {
            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
            startActivity(actividadPrincipal)
        }
    }

}