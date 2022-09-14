package edu.ucne.prestamospersonales.model

import android.widget.DatePicker
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Persons")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombres: String = "",
    val telefono: String = "",
    val celular: String = "",
    val email: String = "",
    val direccion: String ="",
    val fechaNacimiento: String = "",
    val ocupacionId: Int = 0
)