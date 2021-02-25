package com.example.animalapp.PhylumModels


import com.example.animalapp.Abstracts.Animal

internal class MammalsModel(name: String, dietType: String, description: String) :
    Animal(name, dietType, description) {

    private var phylum = "Mammals"
    fun getPhylum(): String {
        return phylum
    }

}