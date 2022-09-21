package edu.ucne.prestamospersonales.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Prestamos")
data class Prestamo (
    @PrimaryKey(autoGenerate = true)
    val prestamosId: Int =0,
    val fecha: String = "",
    val venceFecha: String = "",
    val personaId: Int = 0,
    val concepto: String ="",
    val balance: Double = 0.0
)