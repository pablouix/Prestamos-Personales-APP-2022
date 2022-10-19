package edu.ucne.prestamospersonales.data.remota

import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import retrofit2.Response
import retrofit2.http.*

interface ArticulosApi
{

    // suspend fun getArticulos(): Response<List<ArticuloResponse>>
    @GET("api/Articulos")
    suspend fun getArticulos(): List<ArticuloResponse>

    @DELETE("api/Articulos/{id}")
    suspend fun  DeleteArticulos(@Path("id") id: Int): Response<ArticuloResponse>

    @POST("api/Articulos")
    suspend fun InsertArticulos(@Body articuloResponse: ArticuloResponse) : Response<ArticuloResponse>

}
