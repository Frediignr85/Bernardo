package com.example.ismael.chatprogramator

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

/**
 * Created by Ismael on 17/05/2018.
 */

class notificacionbackground : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var Objeto = Main2Activity()
        val Numero: String = Objeto.ObtenerNumero()
        val Nombre: String = Objeto.ObtenerNombre()
       val Id: Int = Numero.toInt()
      Notificaciones("Recordatorio", "Debe enviar mensaje a: $Numero($Nombre)", Id, context)

    }

    fun Notificaciones(titulo: String, texto: String, id: Int, context: Context) {
        val AdNotificaciones = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val logo: Int = R.mipmap.ic_launcher_round
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
