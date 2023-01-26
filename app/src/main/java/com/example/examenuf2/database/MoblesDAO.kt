package com.example.examenuf2.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.examenuf2.model.Mobles

@Dao
interface MoblesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMoble(moble: Mobles)

    @Query("SELECT *  FROM mobles")
    fun getMoblesByNom() : LiveData<List<Mobles>>

    @Update
    fun updateMoble(moble: Mobles)

    @Delete
    fun deleteMoble(moble: Mobles)
}