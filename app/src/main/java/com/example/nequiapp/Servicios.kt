package com.example.nequiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Servicios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
        val textIdFactura = findViewById<TextView>(R.id.idFacturaText)
        val idFactura = findViewById<EditText>(R.id.idFactura)
        val botonPagar = findViewById<Button>(R.id.pagar)
        val totalFactura = findViewById<TextView>(R.id.total);
        val totalFacturaText = findViewById<TextView>(R.id.totalFacturaText);
        val pagarTotal = findViewById<Button>(R.id.pagarTotal);
        val botonGas = findViewById<ImageButton>(R.id.servicioGas);
        val botonAgua = findViewById<ImageButton>(R.id.servicioAgua);
        val botonLuz = findViewById<ImageButton>(R.id.servicioLuz);
        val salirServicios = findViewById<ImageButton>(R.id.salirServicios)
        fun ocultarContenido(){
            textIdFactura?.visibility = View.INVISIBLE;
            idFactura?.visibility = View.INVISIBLE;
            botonPagar?.visibility = View.INVISIBLE;
        }
        fun mostrarPagoFactura(){
            ocultarContenido();

            totalFactura?.visibility = View.VISIBLE;
            totalFacturaText?.visibility = View.VISIBLE;
            pagarTotal?.visibility = View.VISIBLE;
        }
        fun ocultarPagoFactura(){
            totalFactura?.visibility = View.INVISIBLE;
            totalFacturaText?.visibility = View.INVISIBLE;
            pagarTotal?.visibility = View.INVISIBLE;
        }
        fun mostrarContenido(){
            ocultarPagoFactura()
            textIdFactura?.visibility = View.VISIBLE;
            idFactura?.visibility = View.VISIBLE;
            botonPagar?.visibility = View.VISIBLE;
        }



        botonAgua.setOnClickListener {
            mostrarContenido();
            botonPagar.setOnClickListener {
                val totalSaldo = GlobalData.saldo;
                mostrarPagoFactura()
                totalFactura.text = GlobalData.reciboAgua.toString();
                val pagoRecibo = totalFactura.text.toString().toInt();
                pagarTotal.setOnClickListener {
                    if(totalSaldo<pagoRecibo){
                        Toast.makeText(this,"Saldo insuficiente", Toast.LENGTH_LONG).show()
                    }else{
                        GlobalData.saldo -= pagoRecibo;
                        GlobalData.movimientosLista.add(pagoRecibo.toString())
                        GlobalData.movimientosAcciones.add("Pago recibo Agua")
                        Toast.makeText(this, "Pago del recibo con exito", Toast.LENGTH_LONG).show()
                        val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                        startActivity(actividadPrincipal)
                    }
                }
            }

        }
        botonGas.setOnClickListener {
            mostrarContenido();
            botonPagar.setOnClickListener {
                val totalSaldo = GlobalData.saldo;
                mostrarPagoFactura()
                totalFactura.text = GlobalData.reciboGas.toString();
                val pagoRecibo = totalFactura.text.toString().toInt();
                pagarTotal.setOnClickListener {
                    if(totalSaldo<pagoRecibo){
                        Toast.makeText(this,"Saldo insuficiente", Toast.LENGTH_LONG).show()
                    }else{

                        GlobalData.saldo -= pagoRecibo;
                        GlobalData.movimientosLista.add(pagoRecibo.toString())
                        GlobalData.movimientosAcciones.add("Pago recibo Gas")
                        Toast.makeText(this, "Pago del recibo con exito", Toast.LENGTH_LONG).show()
                        val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                        startActivity(actividadPrincipal)
                    }
                }
            }

        }
        botonLuz.setOnClickListener {
            mostrarContenido();
            botonPagar.setOnClickListener {
                val totalSaldo = GlobalData.saldo;
                mostrarPagoFactura()
                totalFactura.text = GlobalData.reciboLuz.toString();
                val pagoRecibo = totalFactura.text.toString().toInt();
                pagarTotal.setOnClickListener {
                    if(totalSaldo<pagoRecibo){
                        Toast.makeText(this,"Saldo insuficiente", Toast.LENGTH_LONG).show()
                    }else{
                        GlobalData.saldo -= pagoRecibo;
                        GlobalData.movimientosLista.add(pagoRecibo.toString())
                        GlobalData.movimientosAcciones.add("Pago recibo Luz")
                        Toast.makeText(this, "Pago del recibo con exito", Toast.LENGTH_LONG).show()
                        val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
                        startActivity(actividadPrincipal)
                    }
                }
            }

        }
        salirServicios.setOnClickListener {
            val actividadPrincipal = Intent(this, CodigoAcceso::class.java)
            startActivity(actividadPrincipal)
        }




    }


}