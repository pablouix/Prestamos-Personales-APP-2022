package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("Select * from persons")
    fun getAll(): Flow<List<Person>>

    @Query("SELECT * FROM Persons WHERE personaId = :id")
    fun getPerson(id: Int) : Flow<Person>

}