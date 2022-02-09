package com.nandomiranda.superheros.model.superhero

data class Superhero (val id: Int, val name: String,
                      val power_int : Int, val power_stre : Int, val power_speed : Int, val power_durab : Int, val power_power : Int, val power_combat : Int,
                      val bio_fullname: String, val bio_placeBirth: String, val bio_appearance: String, val bio_publisher: String,
                      val appe_gender: String, val appe_race: String, val appe_height: String, val appe_weight: String, val appe_eyeColor: String, val appe_hairColor: String,
                      val work_occupation: String, val work_base: String, val connec_affiliation: String, val connec_relatives: String,
                      val image_Url: String)