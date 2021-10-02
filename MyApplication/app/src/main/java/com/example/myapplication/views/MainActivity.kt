package com.example.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    lateinit var boton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inicializarElemento()
        boton.setOnClickListener(
            View.OnClickListener {  Toast.makeText(this,"El Boton Funciona",
                Toast.LENGTH_LONG).show()}
        )





    }

    private fun inicializarElemento(){
        boton = findViewById(R.id.id_btn)
    }


}