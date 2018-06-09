package com.example.ismael.chatprogramator
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

var Prefs: SharedPreferences?=null
var NombrePreferencia: String ="com.example.ismael.chatprogramator.datos"

class Main2Activity : AppCompatActivity() {
 val funcion= Funciones()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Prefs = this.getSharedPreferences(NombrePreferencia,0)
    }


    public var dia: Int = 0
    public var mes: Int = 0
    public var anio: Int = 0
    public var hora: Int = 0
    public var minutos: Int = 0
    var Numero: String=""
    var Mensaje: String = ""
    var Nombre:String = ""

    @RequiresApi(api = Build.VERSION_CODES.N)
     fun onClick(view: View) {

        if (view === btn_hora) {
            funcion.pulsar(btn_hora)
            val c = Calendar.getInstance()
            hora = c.get(Calendar.HOUR_OF_DAY)
            minutos = c.get(Calendar.MINUTE)

            val tpd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, Hora, minuto ->
                hora=Hora
                minutos = minuto
                tv_hora.text = Hora.toString() + ": " + minuto }, hora, minutos, false)
            tpd.show()
        }

        if (view === btn_fecha) {
            funcion.pulsar(btn_fecha)
            val c = Calendar.getInstance()
            dia = c.get(Calendar.DAY_OF_MONTH)
            mes = c.get(Calendar.MONTH)
            anio = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, anio, mes, dia ->
               // dia = day
               // mes = month
               // anio = year
                tv_fecha.text = dia.toString() + "-" + (mes + 1) + "-" + anio }, anio, mes, dia)
            dpd.show()
        }
    }

    fun Guardar(view: View) {
        if(et_Telefono.text.toString()==""||et_Mensaje.text.toString()=="")
        {
            Toast.makeText(this, "Espacios Obligatorios Vacios", Toast.LENGTH_LONG).show()
        }
        else {
            Mensaje = et_Mensaje.text.toString()
            Numero = et_Telefono.text.toString()
            Nombre = et_Nombre.text.toString()
            funcion.pulsar(btn_Guardar)
            funcion.alarma(Numero.toInt(),this, hora, minutos, dia, mes, anio)
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_LONG).show()
            AsignarDatos(Mensaje, Numero, Nombre)
            Handler().postDelayed({
                et_Telefono.setText("")
                et_Mensaje.setText("")
                tv_fecha.text = ""
                tv_hora.text = ""
                et_Nombre.setText("")
            }, 4000)
        }
    }

    fun ObtenerMensaje():String{

        return Prefs!!.getString("Mensaje","")
    }

    fun ObtenerNumero():String{

        return Prefs!!.getString("Numero","")
    }
    fun ObtenerNombre():String{

        return Prefs!!.getString("Nombre","")
    }

    fun AsignarDatos(Mensaje: String, Numero: String, Nombre:String){
        var editor =  Prefs!!.edit()
        editor.putString("Mensaje", Mensaje)
        editor.putString("Numero", Numero)
        editor.putString("Nombre", Nombre)
        editor.apply()

    }

}
