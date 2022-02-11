package com.nandomiranda.superheros.model.sharedP

import android.app.Application

class SharedP : Application() {

    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}