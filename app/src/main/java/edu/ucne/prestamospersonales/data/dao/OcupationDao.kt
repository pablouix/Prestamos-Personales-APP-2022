package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.model.Ocupation
import kotlinx.coroutines.flow.Flow


@Dao
interface OcupationDao { //suspend fun insertOcupation(ocupation:Ocupation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ocupation: Ocupation)

    @Delete
    suspend fun delete(ocupation: Ocupation)

    @Query("SELECT * " +
            "FROM Ocupations " +
            "WHERE ocupacionId = :ocupationId " +
            "LIMIT 1")
    fun find(ocupationId: Int) :Ocupation

    @Query("Select * from Ocupations")
    fun getAll(): Flow<List<Ocupation>>
}
