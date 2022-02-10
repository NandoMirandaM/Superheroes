package com.nandomiranda.superheros.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nandomiranda.superheros.model.superhero.Superhero

@Dao
interface SHDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(superheroList: MutableList<Superhero>)

    @Query("Select * From superheros")
    fun getSuperheroDB(): MutableList<Superhero>


}