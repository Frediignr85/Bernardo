package com.example.ismael.chatprogramator

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.audiofx.BassBoost
import android.os.Build
import android.os.PowerManager
import android.provider.Settings.*
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import com.example.ismael.chatprogramator.BD.BaseDeDatos
import android.provider.Settings.System.NEXT_ALARM_FORMATTED
import android.provider.Settings.System.getString
import android.provider.Settings.System.NEXT_ALARM_FORMATTED




/**
 * Created by Ismael on 17/05/2018.
 */

class notificacionbackground : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onReceive(context: Context, intent: Intent) {
        var Objeto = Main2Activity()
        val Numero: String = Objeto.ObtenerNumero()
        Objeto.CoBD()
        val data =  Objeto.CoBD().readData()
        val Nombre: String = Objeto.ObtenerNombre()
       val Id: Int = Numero.toInt()

        for (i in 0..(data.size - 1)) {
            if(i==0) {
                val nombre = data.get(i).Id.toString()
            }
        }
        Notificaciones("Debe enviar mensaje a:", Numero + " (" + Nombre + ")" , Id, context)

    }

    fun Notificaciones(titulo: String, texto: String, id: Int, context: Context) {
        val AdNotificaciones = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val logo: Int = R.drawable.notificacion77
        val intent = Intent(context, whatsapp::class.java)
        // intent.putExtra("Mensaje777",mensaje7)
        val pendingIntent = PendingIntent.getActivity(context, id, intent, 0)
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context).setVibrate(longArrayOf(100, 250, 100, 500)).
                setContentIntent(pendingIntent).
                setContentTitle(titulo).
                setContentText(texto).
                setSmallIcon(logo).setAutoCancel(true)

        AdNotificaciones.notify(id, builder.build())
    }
}
