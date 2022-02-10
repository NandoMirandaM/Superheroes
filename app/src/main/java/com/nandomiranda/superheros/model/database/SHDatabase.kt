package com.nandomiranda.superheros.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [Superhero::class], version = 1)
abstract class SHDatabase: RoomDatabase(){
    abstract val SHDao: SHDao
}

private lateinit var INSTANCE: SHDatabase

@OptIn(InternalCoroutinesApi::class)
fun getDatabase(context: Context) : SHDatabase{
    kotlinx.coroutines.internal.synchronized(SHDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext ,
                SHDatabase::class.java ,
                "superhero_db"
            ).build()
        }
        return INSTANCE
    }
}