package com.example.animalapp.Abstracts


internal abstract class Animal internal constructor(name: String, dietType: String, description: String) {
    private var name = name
    private var dietType = dietType
    private var description = description

    fun getName(): String {
        return name
    }


    fun getDietType(): String {
        return dietType
    }

    fun getDescription(): String {
        return description
    }
}