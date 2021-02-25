package com.example.animalapp.PhylumModels


import com.example.animalapp.Abstracts.Animal

internal class BirdsModel(name: String, dietType: String, description: String) :
    Animal(name, dietType, description) {

    private var phylum = "Birds"
    fun getPhylum(): String {
        return phylum
    }

}