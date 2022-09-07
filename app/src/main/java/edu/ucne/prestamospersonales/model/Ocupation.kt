package edu.ucne.prestamospersonales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ocupations")
data class Ocupation(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int =0,
    val descripcion: String ="",
    val salario: String = ""
)