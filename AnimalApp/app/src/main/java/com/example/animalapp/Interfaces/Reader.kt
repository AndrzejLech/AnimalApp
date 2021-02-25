package com.example.animalapp.Interfaces

interface Reader {
    fun readJson(string: String, fileName: String): String;
    fun setData(fileName: String)
}