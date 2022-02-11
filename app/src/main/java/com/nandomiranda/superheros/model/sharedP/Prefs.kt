package com.nandomiranda.superheros.model.sharedP

import android.content.Context

private const val SHARED_NAME = "contadores"
private const val PAGE = "page"
private const val AUX = "aux"
class Prefs(context: Context) {

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun savePage(page: Int){
        storage.edit().putInt(PAGE,page).apply()
    }

    fun saveAux(aux: Int){
        storage.edit().putInt(AUX,aux).apply()
    }

    fun getPage(): Int{
        return storage.getInt(PAGE,1)
    }

    fun getAux(): Int{
        return storage.getInt(AUX,1)
    }

}