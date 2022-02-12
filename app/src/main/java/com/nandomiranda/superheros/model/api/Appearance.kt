package com.nandomiranda.superheros.model.api

import com.squareup.moshi.Json

class Appearance (val gender: String , val race: String , private val height: Array<String> ,
                  private val weight: Array<String> , @Json(name="eye-color") val eye_color:String ,
                  @Json(name="hair-color") val hair_color: String)
{
    val heightP: String
        get()= height[0]

    val weightKg: String
        get() = weight[1]
}