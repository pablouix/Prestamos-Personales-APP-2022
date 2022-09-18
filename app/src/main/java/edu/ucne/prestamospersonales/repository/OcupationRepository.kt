package edu.ucne.prestamospersonales.repository

import edu.ucne.prestamospersonales.data.AppDataBase
import javax.inject.Inject
import edu.ucne.prestamospersonales.model.Ocupation

class OcupationRepository @Inject constructor(
    val db: AppDataBase
) {

    suspend fun insertOcupation(ocupation: Ocupation)
    {
        db.ocuparionDao.insert(ocupation)
    }

    suspend fun deleteOcupation(ocupation: Ocupation)
    {
        db.ocuparionDao.delete(ocupation)
    }

    fun getOcupation(id: Int) = db.ocuparionDao.find(id)

    fun getAll() = db.ocuparionDao.getAll()
}