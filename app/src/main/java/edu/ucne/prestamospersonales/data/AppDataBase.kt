package edu.ucne.prestamospersonales.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.model.Ocupation

import edu.ucne.prestamospersonales.data.dao.OcupationDao


@Database(
    entities = [Ocupation::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase(){
    abstract val ocuparionDao : OcupationDao
}