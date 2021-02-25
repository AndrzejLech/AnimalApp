package com.example.animalapp.PhylumActivities

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.DetailsActivity
import com.example.animalapp.Interfaces.Reader
import com.example.animalapp.PhylumModels.BirdsModel
import com.example.animalapp.R
import kotlinx.android.synthetic.main.birds.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

internal class BirdsActivity : AppCompatActivity(), Reader {
    private lateinit var name: String
    private lateinit var dietType: String
    private lateinit var description: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.birds)
        val intent = Intent(this@BirdsActivity, DetailsActivity::class.java)

        btnStork.setOnClickListener {
            setData("stork.json")
            val stork = BirdsModel(name, dietType, description)
            intent.putExtra("Name", stork.getName())
            intent.putExtra("DietType", stork.getDietType())
            intent.putExtra("Description", stork.getDescription())
            intent.putExtra("Phylum", stork.getPhylum())
            intent.putExtra("image", R.drawable.stork_s)
            startActivity(intent)
        }

        btnAra.setOnClickListener {
            setData("ara.json")
            val ara = BirdsModel(name, dietType, description)
            intent.putExtra("Name", ara.getName())
            intent.putExtra("DietType", ara.getDietType())
            intent.putExtra("Description", ara.getDescription())
            intent.putExtra("Phylum", ara.getPhylum())
            intent.putExtra("image", R.drawable.ara_s)
            startActivity(intent)
        }

        btnSparrow.setOnClickListener {
            setData("sparrow.json")
            val sparrow = BirdsModel(name, dietType, description)
            intent.putExtra("Name", sparrow.getName())
            intent.putExtra("DietType", sparrow.getDietType())
            intent.putExtra("Description", sparrow.getDescription())
            intent.putExtra("Phylum", sparrow.getPhylum())
            intent.putExtra("image", R.drawable.sparrow_s)
            startActivity(intent)

        }

        btnWoodpecker.setOnClickListener {
            setData("woodpecker.json")
            val woodpecker = BirdsModel(name, dietType, description)
            intent.putExtra("Name", woodpecker.getName())
            intent.putExtra("DietType", woodpecker.getDietType())
            intent.putExtra("Description", woodpecker.getDescription())
            intent.putExtra("Phylum", woodpecker.getPhylum())
            intent.putExtra("image", R.drawable.woodpecker_s)
            startActivity(intent)

        }

        btnSwift.setOnClickListener {
            setData("swift.json")
            val swift = BirdsModel(name, dietType, description)
            intent.putExtra("Name", swift.getName())
            intent.putExtra("DietType", swift.getDietType())
            intent.putExtra("Description", swift.getDescription())
            intent.putExtra("Phylum", swift.getPhylum())
            intent.putExtra("image", R.drawable.swift_s)
            startActivity(intent)

        }

    }

    override fun readJson(string: String, fileName: String): String {

        var json: String?
        var variable: String = ""
        try {
            val inputStream: InputStream = assets.open(fileName)
            json = inputStream.bufferedReader().use {
                it.readText()
            }
            var jsonarr = JSONArray(json)
            for (i in 0..jsonarr.length()) {
                var jsonobj = jsonarr.getJSONObject(0)
                variable = jsonobj.getString(string)
            }

        } catch (e: IOException) {
        }
        return variable
    }

    override fun setData(fileName: String) {
        name = readJson("name", fileName)
        dietType = readJson("dietType", fileName)
        description = readJson("description", fileName)
    }
}
