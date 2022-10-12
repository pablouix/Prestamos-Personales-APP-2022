package edu.ucne.prestamospersonales.data.remota.dto

data class ArticuloResponse(
    val ariticuloId: Int = 0,
    val descripcion: String = "",
    val marca: String = "",
    val precio: Double = 0.0,
    val existencia: Double = 0.0,
)