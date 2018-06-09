package com.example.ismael.chatprogramator

import android.app.Activity
import android.os.Bundle

/**
 * Created by Ismael on 13/05/2018.
 */
class notificacion:Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val funcion=Funciones()
      funcion.Notificaciones("Hola","soy una notificacion", 1,this)
      finish()
    }
}