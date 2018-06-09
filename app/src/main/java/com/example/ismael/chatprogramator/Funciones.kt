package com.example.ismael.chatprogramator

import android.app.Activity
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Handler
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Funciones {

    fun alarma(id:Int,contexto: Context, hora: Int, minutos: Int, Dia:Int, Mes:Int, Anio:Int) {
            val Alarma = contexto.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intento = Intent(contexto, notificacionbackground::class.java)
            val pendiente = PendingIntent.getBroadcast(contexto, id, intento, 0)
            val calendario = Calendar.getInstance() as Calendar
            calendario.set(Calendar.HOUR_OF_DAY, hora)
            calendario.set(Calendar.MINUTE, minutos)
            calendario.set(Calendar.DAY_OF_MONTH,Dia)
            calendario.set(Calendar.MONTH, Mes)
            calendario.set(Calendar.YEAR,Anio)
        Alarma.set(AlarmManager.RTC_WAKEUP, calendario.timeInMillis, pendiente)
    }

    fun Notificaciones(titulo: String, texto: String, id: Int, context: Context) {
        val AdNotificaciones = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val logo: Int = R.mipmap.ic_launcher_round
        val intent = Intent(context, whatsappbackground::class.java)
        // intent.putExtra("Mensaje777",mensaje7)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context).setVibrate(longArrayOf(100, 250, 100, 500)).
                setContentIntent(pendingIntent).
                setContentTitle(titulo).
                setContentText(texto).
                setSmallIcon(logo).setAutoCancel(true)

        AdNotificaciones.notify(id, builder.build())
    }

    fun pulsar(boton:Button)
    {
        boton.setTextColor(Color.CYAN)
        Handler().postDelayed({
            boton.setTextColor(Color.WHITE)
        }, 175)
    }
}