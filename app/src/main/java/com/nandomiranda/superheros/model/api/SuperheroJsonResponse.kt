package com.nandomiranda.superheros.model.api

class SuperheroJsonResponse(val id: String, val name: String, val powerstats: Powerstats, val biography: Biography,
                            val appearance: Appearance, val work: Work, val connections: Connections, val image: Image) {
}