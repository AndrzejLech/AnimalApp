package com.example.animalapp.PhylumActivities

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.DetailsActivity
import com.example.animalapp.Interfaces.Reader
import com.example.animalapp.PhylumModels.AmphibiansModel
import com.example.animalapp.R
import kotlinx.android.synthetic.main.amphibians.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

internal class AmphibiansActivity : AppCompatActivity(), Reader {
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
        setContentView(R.layout.amphibians)
        val intent = Intent(this@AmphibiansActivity, DetailsActivity::class.java)
        btnFrog.setOnClickListener {


            setData("frog.json")

            val frog = AmphibiansModel(name, dietType, description)
            intent.putExtra("Name", frog.getName())
            intent.putExtra("DietType", frog.getDietType())
            intent.putExtra("Description", frog.getDescription())
            intent.putExtra("Phylum", frog.getPhylum())
            intent.putExtra("image", R.drawable.frog_s)
            startActivity(intent)
        }

        btnToad.setOnClickListener {
            setData("toad.json")
            val toad = AmphibiansModel(name, dietType, description)
            intent.putExtra("Name", toad.getName())
            intent.putExtra("DietType", toad.getDietType())
            intent.putExtra("Description", toad.getDescription())
            intent.putExtra("Phylum", toad.getPhylum())
            intent.putExtra("image", R.drawable.toad_s)
            startActivity(intent)
        }

        btnNewt.setOnClickListener {
            setData("newt.json")
            val newt = AmphibiansModel(name, dietType, description)
            intent.putExtra("Name", newt.getName())
            intent.putExtra("DietType", newt.getDietType())
            intent.putExtra("Description", newt.getDescription())
            intent.putExtra("Phylum", newt.getPhylum())
            intent.putExtra("image", R.drawable.newt_s)
            startActivity(intent)
        }

        btnAxoatl.setOnClickListener {

            setData("axoatl.json")
            val axoalt = AmphibiansModel(name, dietType, description)
            intent.putExtra("Name", axoalt.getName())
            intent.putExtra("DietType", axoalt.getDietType())
            intent.putExtra("Description", axoalt.getDescription())
            intent.putExtra("Phylum", axoalt.getPhylum())
            intent.putExtra("image", R.drawable.axoatl_s)
            startActivity(intent)

        }

        btnSalamander.setOnClickListener {


            setData("salamander.json")
            val salamander = AmphibiansModel(name, dietType, description)
            intent.putExtra("Name", salamander.getName())
            intent.putExtra("DietType", salamander.getDietType())
            intent.putExtra("Description", salamander.getDescription())
            intent.putExtra("Phylum", salamander.getPhylum())
            intent.putExtra("image", R.drawable.salamander_s)
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
