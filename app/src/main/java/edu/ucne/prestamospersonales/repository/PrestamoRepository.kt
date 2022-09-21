package edu.ucne.prestamospersonales.repository

import edu.ucne.prestamospersonales.data.AppDataBase
import edu.ucne.prestamospersonales.model.Prestamo
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val db: AppDataBase
    ) {

    suspend fun insert(prestamo: Prestamo){
        db.prestamoDao.insert(prestamo)
    }

    suspend fun delete(prestamo: Prestamo){
        db.prestamoDao.delete(prestamo)
    }

    fun getPrestamo(id: Int) = db.prestamoDao.find(id)

    fun getAll() = db.prestamoDao.getAll()

}