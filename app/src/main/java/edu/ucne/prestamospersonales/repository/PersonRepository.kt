package edu.ucne.prestamospersonales.repository

import edu.ucne.prestamospersonales.data.AppDataBase
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.model.Person
import javax.inject.Inject

class PersonRepository @Inject constructor(
    val db: AppDataBase
) {

    suspend fun insert(person: Person)
    {
        db.personDao.insert(person)
    }

    suspend fun update(person: Person)
    {
        db.personDao.update(person)
    }



    suspend fun delete(person: Person)
    {
        db.personDao.delete(person)
    }

    fun getPerson(id: Int) = db.personDao.getPerson(id)

    fun getAll() = db.personDao.getAll()



}