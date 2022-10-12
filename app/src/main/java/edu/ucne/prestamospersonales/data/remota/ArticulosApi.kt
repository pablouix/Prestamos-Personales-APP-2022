package edu.ucne.prestamospersonales.data.remota

import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticulosApi
{
    @GET("api/Articulos")
    suspend fun get(): Response<List<ArticuloResponse>>
}
