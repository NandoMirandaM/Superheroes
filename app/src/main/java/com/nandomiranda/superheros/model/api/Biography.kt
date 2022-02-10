package com.nandomiranda.superheros.model.api

import com.squareup.moshi.Json

data class Biography(@Json(name = "full-name") val fullname: String ,@Json(name ="place-of-birth") val place_of_birth: String ,
                @Json(name = "first-appearance") val first_appearance: String , val publisher: String , )