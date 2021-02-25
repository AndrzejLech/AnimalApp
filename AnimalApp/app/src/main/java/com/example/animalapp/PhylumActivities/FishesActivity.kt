package com.example.animalapp.PhylumActivities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.animalapp.DetailsActivity
import com.example.animalapp.Interfaces.Reader
import com.example.animalapp.PhylumModels.FishesModel
import com.example.animalapp.R
import kotlinx.android.synthetic.main.fishes.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

internal class FishesActivity : AppCompatActivity(), Reader {
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
        setContentView(R.layout.fishes)
        val intent = Intent(this@FishesActivity, DetailsActivity::class.java)

        btnCatfish.setOnClickListener {
            setData("catfish.json")
            val catfish = FishesModel(name, dietType, description)
            intent.putExtra("Name", catfish.getName())
            intent.putExtra("DietType", catfish.getDietType())
            intent.putExtra("Description", catfish.getDescription())
            intent.putExtra("Phylum", catfish.getPhylum())
            intent.putExtra("image", R.drawable.catfish_s)
            startActivity(intent)
        }

        btnAmphirion.setOnClickListener() {
            setData("amphirion.json")
            val amphirion = FishesModel(name, dietType, description)
            intent.putExtra("Name", amphirion.getName())
            intent.putExtra("DietType", amphirion.getDietType())
            intent.putExtra("Description", amphirion.getDescription())
            intent.putExtra("Phylum", amphirion.getPhylum())
            intent.putExtra("image", R.drawable.amfiprion_s)
            startActivity(intent)
        }

        btnLionfish.setOnClickListener() {
            setData("lionfish.json")
            val lionfish = FishesModel(name, dietType, description)
            intent.putExtra("Name", lionfish.getName())
            intent.putExtra("DietType", lionfish.getDietType())
            intent.putExtra("Description", lionfish.getDescription())
            intent.putExtra("Phylum", lionfish.getPhylum())
            intent.putExtra("image", R.drawable.lionfish_s)
            startActivity(intent)
        }

        btnTrout.setOnClickListener() {
            setData("trout.json")
            val trout = FishesModel(name, dietType, description)
            intent.putExtra("Name", trout.getName())
            intent.putExtra("DietType", trout.getDietType())
            intent.putExtra("Description", trout.getDescription())
            intent.putExtra("Phylum", trout.getPhylum())
            intent.putExtra("image", R.drawable.trout_s)
            startActivity(intent)
        }

        btnFightingFish.setOnClickListener() {
            setData("fightingfish.json")
            val fightingFish = FishesModel(name, dietType, description)
            intent.putExtra("Name", fightingFish.getName())
            intent.putExtra("DietType", fightingFish.getDietType())
            intent.putExtra("Description", fightingFish.getDescription())
            intent.putExtra("Phylum", fightingFish.getPhylum())
            intent.putExtra("image", R.drawable.fighting_fish_s)

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
