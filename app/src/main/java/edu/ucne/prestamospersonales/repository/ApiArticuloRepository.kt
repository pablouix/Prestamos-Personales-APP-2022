package edu.ucne.prestamospersonales.repository

import edu.ucne.prestamospersonales.data.remota.ArticulosApi
import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiArticuloRepository @Inject constructor(
    private val api: ArticulosApi
)
{
    suspend fun get(): List<ArticuloResponse>
    {
        return withContext(Dispatchers.IO)
        {
            val response = api.get()
            response.body()?: emptyList()
        }

    }

}
