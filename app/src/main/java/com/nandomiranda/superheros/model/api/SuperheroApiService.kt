package com.nandomiranda.superheros.model.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApiService {
    @GET("10220161311159074/{id}")
    suspend fun getSuperheroes(@Path("id") id: Int?): SuperheroJsonResponse
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://superheroapi.com/api/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service: SuperheroApiService = retrofit.create(SuperheroApiService::class.java)