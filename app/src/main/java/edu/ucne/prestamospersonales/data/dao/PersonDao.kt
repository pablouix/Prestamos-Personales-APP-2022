package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT * " +
            "FROM Persons "+
            "WHERE personaId = :id " +
            "LIMIT 1")
    fun find(id: Int) : Person

    @Query("Select * from persons")
    fun getAll(): Flow<List<Person>>
}