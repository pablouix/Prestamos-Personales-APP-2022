package edu.ucne.prestamospersonales.ui.articulos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.repository.ApiArticuloRepository
import edu.ucne.prestamospersonales.repository.OcupationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject() constructor(
    val repository: ApiArticuloRepository
) : ViewModel(){
    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var precio by mutableStateOf("")
    var existencia by mutableStateOf("")


    fun Save()
    {

        viewModelScope.launch {
            repository.saveArticulos(
                ArticuloResponse(
                    descripcion = descripcion,
                    marca = marca,
                    precio = precio.toDouble(),
                    existencia = existencia.toDouble()
                )
            )
        }
        /*
        viewModelScope.launch{
            repository.(
                Ocupation(
                    descripcion = descripcion,
                    salario = salario
                )
            )

        }

         */
    }

}