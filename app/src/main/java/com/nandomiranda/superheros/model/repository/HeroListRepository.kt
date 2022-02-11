package com.nandomiranda.superheros.model.repository

import com.nandomiranda.superheros.model.api.SuperheroJsonResponse
import com.nandomiranda.superheros.model.api.service
import com.nandomiranda.superheros.model.database.SHDatabase
import com.nandomiranda.superheros.model.sharedP.SharedP.Companion.prefs
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroListRepository(private val database: SHDatabase) {

    lateinit var superhero: MutableList<Superhero>
    private var page = prefs.getPage()
    private var aux = prefs.getAux()

    suspend fun fetchSuperhero(): MutableList<Superhero> {
        return withContext(Dispatchers.IO){
            for (id in aux..page*10){
                val heroListJson = service.getSuperheroes(id)
                val heroList = parseHeroResult(heroListJson)
                database.SHDao.insertAll(heroList)

            }
            aux += 10
            page++
            prefs.savePage(page)
            prefs.saveAux(aux)
            superhero = database.SHDao.getSuperheroDB()
            superhero
        }
    }

    private fun parseHeroResult(superheroJsonResponse: SuperheroJsonResponse):MutableList<Superhero> {
        val heroList = mutableListOf<Superhero>()

        val id = superheroJsonResponse.id
        val name = superheroJsonResponse.name

        //PowerStats
        val powerStats = superheroJsonResponse.powerstats
        val intelligence = powerStats.intelligence
        val strength = powerStats.strength
        val speed = powerStats.speed
        val durability = powerStats.durability
        val power = powerStats.power
        val combat = powerStats.combat

        //Biography
        val biography = superheroJsonResponse.biography
        val fullN = biography.fullname
        val placeOfBirth = biography.place_of_birth
        val firstAppe = biography.first_appearance
        val publisher = biography.publisher

        //appearance
        val appearance = superheroJsonResponse.appearance
        val gender= appearance.gender
        val race= appearance.race
        val height= appearance.heightCm
        val weight= appearance.weightKg
        val eyeColor= appearance.eye_color
        val hairColor= appearance.hair_color

        //Work
        val work = superheroJsonResponse.work
        val occupation = work.occupation
        val base = work.base

        //connections
        val connection = superheroJsonResponse.connections
        val affiliation = connection.group_affiliation
        val relatives = connection.relatives

        //image
        val image= superheroJsonResponse.image
        val url= image.url

        heroList.add(
            Superhero(id,name,intelligence,strength,speed,durability,power,combat,fullN,placeOfBirth,firstAppe,publisher,
            gender,race,height,weight,eyeColor,hairColor,occupation,base,affiliation,relatives,url)
        )

        return heroList
    }
}