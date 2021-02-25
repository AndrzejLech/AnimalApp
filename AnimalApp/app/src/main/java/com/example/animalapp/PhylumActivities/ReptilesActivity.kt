package com.example.animalapp.PhylumActivities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.DetailsActivity
import com.example.animalapp.Interfaces.Reader
import com.example.animalapp.PhylumModels.ReptilesModel
import com.example.animalapp.R
import kotlinx.android.synthetic.main.reptiles.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

internal class ReptilesActivity : AppCompatActivity(), Reader {
    private lateinit var name: String
    private lateinit var dietType: String
    private lateinit var description: String
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.reptiles)

        val intent = Intent(this@ReptilesActivity, DetailsActivity::class.java)

        btnTurtle.setOnClickListener {
            setData("turtle.json")
            val turtle = ReptilesModel(name, dietType, description)
            intent.putExtra("Name", turtle.getName())
            intent.putExtra("DietType", turtle.getDietType())
            intent.putExtra("Description", turtle.getDescription())
            intent.putExtra("Phylum", turtle.getPhylum())
            intent.putExtra("image", R.drawable.turtle_s)
            startActivity(intent)
        }

        btnIguana.setOnClickListener {
            setData("iguana.json")
            val iguana = ReptilesModel(name, dietType, description)
            intent.putExtra("Name", iguana.getName())
            intent.putExtra("DietType", iguana.getDietType())
            intent.putExtra("Description", iguana.getDescription())
            intent.putExtra("Phylum", iguana.getPhylum())
            intent.putExtra("image", R.drawable.iguana_s)
            startActivity(intent)
        }

        btnMonitorLizard.setOnClickListener() {
            setData("monitorlizard.json")
            val monitorLizard = ReptilesModel(name, dietType, description)
            intent.putExtra("Name", monitorLizard.getName())
            intent.putExtra("DietType", monitorLizard.getDietType())
            intent.putExtra("Description", monitorLizard.getDescription())
            intent.putExtra("Phylum", monitorLizard.getPhylum())
            intent.putExtra("image", R.drawable.monitor_lizard_s)
            startActivity(intent)
        }

        btnChameleon.setOnClickListener() {
            setData("chameleon.json")
            val chameleon = ReptilesModel(name, dietType, description)
            intent.putExtra("Name", chameleon.getName())
            intent.putExtra("DietType", chameleon.getDietType())
            intent.putExtra("Description", chameleon.getDescription())
            intent.putExtra("Phylum", chameleon.getPhylum())
            intent.putExtra("image", R.drawable.chameleon_s)
            startActivity(intent)
        }

        btnGecko.setOnClickListener() {
            setData("gecko.json")
            val gecko = ReptilesModel(name, dietType, description)
            intent.putExtra("Name", gecko.getName())
            intent.putExtra("DietType", gecko.getDietType())
            intent.putExtra("Description", gecko.getDescription())
            intent.putExtra("Phylum", gecko.getPhylum())
            intent.putExtra("image", R.drawable.gecko_s)
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
