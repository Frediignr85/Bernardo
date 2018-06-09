package com.example.ismael.chatprogramator

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

/**
 * Created by Ismael on 13/05/2018.
 */
class whatsapp:Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val Objeto = Main2Activity()
            val Mensaje:String = Objeto.ObtenerMensaje()
            whatsapp1(Mensaje)
            finish()
        }

    fun whatsapp1(msm: String)
    {
        val uri: Uri = Uri.parse("smsto: " )
        val it = Intent(Intent.ACTION_SEND_MULTIPLE, uri)
        it.type = "text/plain"
        // val info: PackageInfo = algo.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA)
        it.`package` = "com.whatsapp"
        it.putExtra(Intent.EXTRA_TEXT, msm)
        it.putExtra("sms_body", msm)
        it.putExtra("chat", true)
        // it.setType("text/plain")
        startActivity(it)
        // Toast.makeText(this, "El mensaje es" + toast, Toast.LENGTH_LONG).show()
    }
}