package com.example.ismael.chatprogramator

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity

/**
 * Created by Ismael on 19/05/2018.
 */
class whatsappbackground: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val algo = whatsapp()
        val Objeto = Main2Activity()
        val Mensaje:String = Objeto.ObtenerMensaje()
        algo.whatsapp1(Mensaje)
    }

}