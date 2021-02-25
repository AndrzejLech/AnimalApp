package com.example.animalapp.PhylumModels


import com.example.animalapp.Abstracts.Animal

internal class AmphibiansModel(name: String, dietType: String, description: String):Animal(name, dietType, description) {

    private var phylum = "Amphibians"

    fun getPhylum(): String {
        return phylum
    }

}