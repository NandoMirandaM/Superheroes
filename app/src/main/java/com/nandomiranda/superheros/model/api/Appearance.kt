package com.nandomiranda.superheros.model.api

class Appearance (val gender: String, val race: String, private val height: Array<String>,
                  private val weight: Array<String>, val eye_color:String, val hair_color: String)
{

    val heightCm: String
    get() = height[1]

    val weightKg: String
        get() = weight[1]
}