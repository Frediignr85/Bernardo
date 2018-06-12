package com.example.ismael.chatprogramator

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.example.ismael.chatprogramator.BD.BaseDeDatos
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
 val funcion = Funciones()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    }

    fun Nuevo(view: View)
    {
        funcion.pulsar(btn_Nuevo)
        val intento= Intent(this, Main2Activity::class.java)
        startActivity(intento)
    }

    fun lista(view: View)
    {
        funcion.pulsar(btn_Lista)
        val intento= Intent(this, MostrarMensajes::class.java)
        startActivity(intento)
    }

    fun salir(view: View)
    {
        funcion.pulsar(btn_Salir)
        val dialog= AlertDialog.Builder(this@menu)
        dialog.setTitle("Confirmar")
        dialog.setMessage("¿Desea salir de la Aplicación?")

        dialog.setPositiveButton("SI"){ d, whitch ->
            System.exit(0)
        }

        dialog.setNegativeButton("NO"){ d, whitch ->

        }
        dialog.show()
    }

    fun deleteData(view: View){
        funcion.pulsar(btnBorrar)
       var funcion = BaseDeDatos(this)
        funcion.borrar()
    }

}
