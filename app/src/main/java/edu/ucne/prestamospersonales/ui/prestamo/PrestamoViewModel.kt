package edu.ucne.prestamospersonales.ui.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.model.Prestamo
import edu.ucne.prestamospersonales.repository.PrestamoRepository
import edu.ucne.prestamospersonales.ui.prestamo_list.PrestamoListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PrestamoViewModel @Inject() constructor(
    val repository: PrestamoRepository)
    : ViewModel(){

    var fecha by mutableStateOf("")
    var vencefecha by mutableStateOf("")
    var personaId by mutableStateOf(0)
    var concepto by mutableStateOf("")
    var balance by mutableStateOf(0.0)

    private val _uiState = MutableStateFlow(PrestamoListUiState())
    val uiState: StateFlow<PrestamoListUiState> = _uiState.asStateFlow()

    fun Save()
    {
        viewModelScope.launch {
            repository.insert(
                Prestamo(
                    fecha = fecha,
                    venceFecha = vencefecha,
                    personaId = personaId,
                    concepto = concepto,
                    balance = balance
                )
            )
        }
    }

    fun Delete()
    {
        viewModelScope.launch {
            repository.delete(
                Prestamo()
            )
        }
    }

    fun getAll(){
        viewModelScope.launch{
            repository.getAll()
        }
    }
}