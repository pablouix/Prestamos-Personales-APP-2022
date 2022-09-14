package edu.ucne.prestamospersonales.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.model.Ocupation

import edu.ucne.prestamospersonales.data.dao.OcupationDao
import edu.ucne.prestamospersonales.data.dao.PersonDao
import edu.ucne.prestamospersonales.model.Person


@Database(
    entities = [Ocupation::class, Person::class],
    version = 4
)
abstract class AppDataBase : RoomDatabase(){
    abstract val ocuparionDao : OcupationDao
    abstract val personDao : PersonDao

}