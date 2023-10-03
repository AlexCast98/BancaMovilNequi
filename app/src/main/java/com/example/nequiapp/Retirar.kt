package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Retirar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retirar)
        val cantidad = findViewById<EditText>(R.id.cantidadRetirar)
        val codigo = findViewById<EditText>(R.id.codigoRetirar)
        val botonRetirar = findViewById<Button>(R.id.idRetirar)
        val salirBtn = findViewById<ImageButton>(R.id.salirRetiro);
        botonRetirar.setOnClickListener {
            if(!(cantidad.text.toString().isNullOrEmpty() && codigo.text.toString().isNullOrEmpty())){
                if(codigo.text.toString() == GlobalData.codigoGenerado) {
                    val cantidadValue = cantidad.text.toString().toInt()
                    if(cantidadValue>=10000){
                        if(cantidadValue.toString().isNotEmpty()){
                            if(cantidadValue<=GlobalData.saldo){
                                GlobalData.saldo -= cantidadValue;
                                GlobalData.movimientosLista.add(cantidadValue.toString())
                                GlobalData.movimientosAcciones.add("Retiro")
                                Toast.makeText(this, "Retiro exitoso", Toast.LENGTH_LONG).show()
                                val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                                startActivity(actividadPrincipal)


                            }else{
                                Log.d("MiTag", cantidadValue.toString())
                                Toast.makeText(this,"Saldo insuficiente", Toast.LENGTH_LONG).show()
                            }

                        }else{
                            Toast.makeText(this,"La app no funciona", Toast.LENGTH_LONG).show()
                        }

                    }else{
                        Toast.makeText(this,"El minimo de retiro es de 10.000 pesos", Toast.LENGTH_LONG).show()

                    }

                }else{
                    Toast.makeText(this,"El codigo que ingresaste no es correcto", Toast.LENGTH_LONG).show()
                }

            }
            }
        salirBtn.setOnClickListener {
            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
            startActivity(actividadPrincipal)
        }
        }


    }
