package edu.ucne.prestamospersonales.data.remota

import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticulosApi
{

    // suspend fun getArticulos(): Response<List<ArticuloResponse>>
    @GET("api/Articulos")
    suspend fun getArticulos(): List<ArticuloResponse>
}
