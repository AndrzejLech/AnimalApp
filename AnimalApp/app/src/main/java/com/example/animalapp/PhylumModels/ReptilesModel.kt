package com.example.animalapp.PhylumModels


import com.example.animalapp.Abstracts.Animal

internal class ReptilesModel(name: String, dietType: String, description: String) :
    Animal(name, dietType, description) {

    private var phylum = "Reptiles"
    fun getPhylum(): String {
        return phylum
    }

}