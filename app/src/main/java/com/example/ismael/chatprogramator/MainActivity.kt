package com.example.ismael.chatprogramator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intento= Intent(this, menu::class.java)
            startActivity(intento)
            finish()
        }, 2000)

    }
}
