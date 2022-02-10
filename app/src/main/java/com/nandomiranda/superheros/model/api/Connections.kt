package com.nandomiranda.superheros.model.api

import com.squareup.moshi.Json

class Connections(@Json(name="group-affiliation")val group_affiliation: String , val relatives:String)