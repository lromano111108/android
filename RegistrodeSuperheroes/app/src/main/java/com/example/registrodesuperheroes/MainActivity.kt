package com.example.registrodesuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.example.registrodesuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var heroImage: ImageView
    companion object{
        const val SUPERHERO_NAME_KEY ="superhero_name"
        const val ALTER_EGO_KEY ="alter_ego"
        const val BIO_KEY ="bio"
        const val POWER_KEY ="power"


        private var heroBitmap: Bitmap? = null
        val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
                bitmap ->
            heroBitmap = bitmap
            heroImage.setImageBitmap(heroBitmap!!)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener{
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.editBio.text.toString()
            val power = binding.powerBar.rating
            val hero = SuperHero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }

        heroImage = binding.heroImage

        heroImage.setOnClickListener{
            openCamera()
        }

    }

    private fun openCamera() {
        /*val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)*/
        getContent.launch(null)
        startActivityForResult(cameraIntent, 1000)
    }

    private fun openDetailActivity(superhero: SuperHero){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        intent.putExtra(DetailActivity.BITMAP_KEY, heroImage.drawable.toBitmap())
       /* intent.putExtra(DetailActivity.SUPERHERO_NAME_KEY, superHeroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(DetailActivity.BIO_KEY, bio)
        intent.putExtra(DetailActivity.POWER_KEY, power)*/
        startActivity(intent)
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK && requestCode == 1000){
            val extras = data?.extras
            val heroBitMap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitMap!!)

        }*/
    }
