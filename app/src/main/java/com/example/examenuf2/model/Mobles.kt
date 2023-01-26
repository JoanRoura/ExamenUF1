package com.example.examenuf2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "mobles")
data class Mobles(
    @ColumnInfo(name = "nom")
    var nom: String,
    @ColumnInfo(name = "preu")
    var preu: Int,

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}