package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.model.Person
import edu.ucne.prestamospersonales.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prestamo: Prestamo)

    @Delete
    suspend fun delete(prestamo: Prestamo)

    @Query("SELECT * " +
            "FROM Prestamos "+
            "WHERE prestamosId = :id " +
            "LIMIT 1")
    fun find(id: Int) : Prestamo

    @Query("Select * from Prestamos")
    fun getAll(): Flow<List<Prestamo>>
}