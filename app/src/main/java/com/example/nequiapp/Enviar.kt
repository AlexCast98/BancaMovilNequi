package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Enviar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar)
        val numero = findViewById<EditText>(R.id.numeroEnviar)
        val cantidad = findViewById<EditText>(R.id.cantidadRetirar)
        val botonRetirar = findViewById<Button>(R.id.idRetirar)
        val salirEnviar = findViewById<ImageButton>(R.id.salirEnviar);

        botonRetirar.setOnClickListener{
            if(!cantidad.text.toString().isNullOrEmpty()){
            val numeroText = numero.text.toString()
            val cantidadValue = cantidad.text.toString().toInt()
            if (numeroText.length==10){
                if(cantidadValue>100){
                    if(!(cantidadValue.toString().isNullOrEmpty())){
                        if(cantidadValue<=GlobalData.saldo){
                            GlobalData.saldo -= cantidadValue;
                            GlobalData.movimientosLista.add(cantidadValue.toString())
                            GlobalData.movimientosAcciones.add("Envio")
                            Toast.makeText(this, "Envío exitoso", Toast.LENGTH_LONG).show()
                            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                            startActivity(actividadPrincipal)

                        }else{
                            Log.d("MiTag", cantidadValue.toString())
                            Toast.makeText(this,"Saldo insuficiente",Toast.LENGTH_LONG).show()
                        }

                    }else{
                        Toast.makeText(this,"El minimo de envio es de 100 pesos",Toast.LENGTH_LONG).show()
                    }

                }
            }else{
                Toast.makeText(this,"Ingresa un numero valido",Toast.LENGTH_LONG).show()

            }
        }}
        salirEnviar.setOnClickListener {
            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
            startActivity(actividadPrincipal)
        }





    }
}