package com.example.animalapp.PhylumModels


import com.example.animalapp.Abstracts.Animal

internal class FishesModel(name: String, dietType: String, description: String) :
    Animal(name, dietType, description) {

    private var phylum = "Fishes"
    fun getPhylum(): String {
        return phylum
    }

}