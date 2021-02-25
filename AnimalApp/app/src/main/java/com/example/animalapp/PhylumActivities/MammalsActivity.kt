package com.example.animalapp.PhylumActivities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.DetailsActivity
import com.example.animalapp.Interfaces.Reader
import com.example.animalapp.PhylumModels.MammalsModel
import com.example.animalapp.R
import kotlinx.android.synthetic.main.mammals.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream


internal class MammalsActivity : AppCompatActivity(), Reader {
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
        setContentView(R.layout.mammals)

        val intent = Intent(this@MammalsActivity, DetailsActivity::class.java)

        btnLion.setOnClickListener {
            setData("lion.json")
            val lion = MammalsModel(name, dietType, description)
            intent.putExtra("Name", lion.getName())
            intent.putExtra("DietType", lion.getDietType())
            intent.putExtra("Description", lion.getDescription())
            intent.putExtra("Phylum", lion.getPhylum())
            intent.putExtra("image", R.drawable.lion_s)
            startActivity(intent)
        }

        btnKangaroo.setOnClickListener {
            setData("kangaroo.json")
            val kangaroo = MammalsModel(name, dietType, description)
            intent.putExtra("Name", kangaroo.getName())
            intent.putExtra("DietType", kangaroo.getDietType())
            intent.putExtra("Description", kangaroo.getDescription())
            intent.putExtra("Phylum", kangaroo.getPhylum())
            intent.putExtra("image", R.drawable.kangaroo_s)
            startActivity(intent)
        }



        btnFox.setOnClickListener {
            setData("fox.json")
            val fox = MammalsModel(name, dietType, description)
            intent.putExtra("Name", fox.getName())
            intent.putExtra("DietType", fox.getDietType())
            intent.putExtra("Description", fox.getDescription())
            intent.putExtra("Phylum", fox.getPhylum())
            intent.putExtra("image", R.drawable.fox_s)
            startActivity(intent)
        }

        btnMeerkat.setOnClickListener {
            setData("meerkat.json")
            val meerkat = MammalsModel(name, dietType, description)
            intent.putExtra("Name", meerkat.getName())
            intent.putExtra("DietType", meerkat.getDietType())
            intent.putExtra("Description", meerkat.getDescription())
            intent.putExtra("Phylum", meerkat.getPhylum())
            intent.putExtra("image", R.drawable.meerkat_s)
            startActivity(intent)
        }

        btnGorilla.setOnClickListener {



            setData("gorilla.json")



            val gorilla = MammalsModel(name, dietType, description)
            intent.putExtra("Name", gorilla.getName())
            intent.putExtra("DietType", gorilla.getDietType())
            intent.putExtra("Description", gorilla.getDescription())
            intent.putExtra("Phylum", gorilla.getPhylum())
            intent.putExtra("image", R.drawable.gorilla_s)
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






