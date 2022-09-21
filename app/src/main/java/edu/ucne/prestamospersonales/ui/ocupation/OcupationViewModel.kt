package edu.ucne.prestamospersonales.ui.ocupation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.repository.OcupationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OcupationViewModel @Inject() constructor(
    val repository: OcupationRepository
) : ViewModel(){

    var descripcion by mutableStateOf("")
    var salario by mutableStateOf(0.0)


    fun Save()
    {
        viewModelScope.launch{
            repository.insertOcupation(
                Ocupation(
                    descripcion = descripcion,
                    salario = salario
                )
            )

        }
    }

}