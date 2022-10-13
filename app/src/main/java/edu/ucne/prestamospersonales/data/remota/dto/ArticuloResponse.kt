package edu.ucne.prestamospersonales.data.remota.dto

import com.squareup.moshi.Json

data class ArticuloResponse(
// esto es de moshi
    @Json(name = "ariticuloId")
    val articuloId: Int = 0,
    val descripcion: String = "",
    val marca: String = "",
    val precio: Double = 0.0,
    val existencia: Double = 0.0,
)