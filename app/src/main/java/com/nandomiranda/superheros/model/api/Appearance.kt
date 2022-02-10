package com.nandomiranda.superheros.model.api

import com.squareup.moshi.Json

class Appearance (val gender: String , val race: String , private val height: Array<String> ,
                  private val weight: Array<String> , @Json(name="eye-color") val eye_color:String ,
                  @Json(name="hair-color") val hair_color: String)
{
    val heightCm: String
    get() = height[1]

    val weightKg: String
        get() = weight[1]
}