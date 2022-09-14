package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.model.Ocupation
import kotlinx.coroutines.flow.Flow


@Dao
interface OcupationDao { //suspend fun insertOcupation(ocupation:Ocupation)

    @Insert
    suspend fun insertOcupation(ocupation: Ocupation)

    @Update
    suspend fun updateOcupation(ocupation: Ocupation)

    @Delete
    suspend fun deleteOcupation(ocupation: Ocupation)

    @Query("SELECT * FROM Ocupations WHERE ocupacionId = :id")
    fun getOcupation(id: Int) : Flow<Ocupation>

    @Query("Select * from Ocupations")
    fun getAll(): Flow<List<Ocupation>>
}
