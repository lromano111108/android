package com.example.registrodesuperheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.registrodesuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY ="superhero"
        const val BITMAP_KEY ="bitmap"
        /*const val ALTER_EGO_KEY ="alter_ego"
        const val BIO_KEY ="bio"
        const val POWER_KEY ="power"*/
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHero: SuperHero = bundle.getParcelable<SuperHero>(SUPERHERO_KEY)!!
        val bitmap: Bitmap = bundle.getParcelable<Bitmap>(BITMAP_KEY)!!
        /*val superheroName = bundle.getString(SUPERHERO_NAME_KEY)?:""
        val alterEgo = bundle.getString(ALTER_EGO_KEY)?:""
        val bio = bundle.getString(BIO_KEY )?:""
        val power = bundle.getFloat(POWER_KEY)*/
      /*  val superheroName = bundle.getString("superhero_name")?:""
        val alterEgo = bundle.getString("alter_ego")?:""
        val bio = bundle.getString("bio")?:""
        val power = bundle.getFloat("power")*/


        /* binding.heroName.text=superHero.name
         binding.alterEgotext.text=superHero.alterEgo
         binding.bioText.text=superHero.bio
         binding.ratingBar.rating=superHero.power
         binding.bioText.text=bio
         binding.ratingBar.rating=power*/


        binding.superhero=superHero
        binding.detailImageView.setImageBitmap(bitmap)

    }
}