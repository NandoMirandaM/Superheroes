package com.nandomiranda.superheros.model.superhero

data class Superhero (val id: String, val name: String,
                      val power_int : String, val power_stre : String, val power_speed : String, val power_durab : String, val power_power : String, val power_combat : String,
                      val bio_fullname: String, val bio_placeBirth: String, val bio_appearance: String, val bio_publisher: String,
                      val appe_gender: String, val appe_race: String, val appe_height: String, val appe_weight: String, val appe_eyeColor: String, val appe_hairColor: String,
                      val work_occupation: String, val work_base: String, val connec_affiliation: String, val connec_relatives: String,
                      val image_Url: String)