package com.example.animalapp


import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.details.*
import android.os.Bundle


internal class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        animalName.text = intent.getStringExtra("Name")
        animalDescription.text = intent.getStringExtra("Description")
        animalDietType.text = intent.getStringExtra("DietType")
        animalPhylium.text = intent.getStringExtra("Phylum")
        val bundle = intent.extras
        val id: Int
        if (bundle != null) {
            id = bundle.getInt("image")
            animalImage.setImageResource(id)
        }
    }

}
