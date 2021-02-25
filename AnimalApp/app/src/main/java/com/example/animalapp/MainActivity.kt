package com.example.animalapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.PhylumActivities.*
import kotlinx.android.synthetic.main.main.*


internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        btnAmphibians.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, AmphibiansActivity::class.java))
        }

        btnBirds.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, BirdsActivity::class.java))
        }

        btnFishes.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, FishesActivity::class.java))
        }

        btnMammals.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, MammalsActivity::class.java))
        }

        btnReptiles.setOnClickListener()
        {
            startActivity(Intent(this@MainActivity, ReptilesActivity::class.java))
        }

    }
}