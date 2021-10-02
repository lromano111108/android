package com.example.miedadcanina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.miedadcanina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {/*este metodo se ejecuta cuando se abre la pantalla*/
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val age_edit = binding.ageEdit

        //age_edit es un tipo EditText = apunta al elemento y lo busca por su nombre de id.
        //val result_text = findViewById<TextView>(R.id.result_text)
        //val result_text = binding.resultText

        //val button = findViewById<Button>(R.id.button)
       // val button = binding.button




        Log.v("MainActivity", "Activity created Verbose")
        Log.d("MainActivity", "Activity created debug")
        Log.i("MainActivity", "Activity created info")
        Log.w("MainActivity", "Activity created warning")
        Log.e("MainActivity", "Activity created error")
        
        
        binding.button.setOnClickListener(View.OnClickListener {
            val ageString = binding.ageEdit.text.toString()
            if(ageString.isNotEmpty()){
                val ageInt = ageString.toInt()
                val result = ageInt * 7
                binding.resultText.text = getString(R.string.result_text,result)
            } else{
                Log.d("MainActivity", "Age String is empty")
                Toast.makeText(this,getString(R.string.you_must_insert_insert_your_age), Toast.LENGTH_SHORT).show()
            }

        })




    }
}