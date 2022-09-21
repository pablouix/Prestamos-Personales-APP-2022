package edu.ucne.prestamospersonales.ui.person

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.model.Person
import edu.ucne.prestamospersonales.repository.PersonRepository
import edu.ucne.prestamospersonales.ui.prestamo_list.PrestamoListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PersonViewModel @Inject() constructor(
    val repository: PersonRepository
) : ViewModel(){

    var nombres by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("")
    var ocupacionId by mutableStateOf(0)
    var balance by mutableStateOf(0.0)


    fun Save()
    {
        viewModelScope.launch{
            repository.insert(
                Person(
                    nombres = nombres,
                    telefono = telefono,
                    celular = celular,
                    email = email,
                    direccion = direccion,
                    fechaNacimiento = fechaNacimiento,
                    ocupacionId = ocupacionId,
                    balance = balance
                )
            )

        }
    }

    fun getAll(){
        viewModelScope.launch{
            repository.getAll()
        }
    }

}