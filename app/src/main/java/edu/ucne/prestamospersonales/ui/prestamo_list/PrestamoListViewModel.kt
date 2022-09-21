package edu.ucne.prestamospersonales.ui.prestamo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.model.Prestamo
import edu.ucne.prestamospersonales.repository.PrestamoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PrestamoListUiState(
    val prestamo: List<Prestamo> = emptyList(),
    val text: String = "Meeting"
)


@HiltViewModel

class PrestamoListViewModel @Inject constructor(
    val repository: PrestamoRepository
) : ViewModel(){

    private val _uiState = MutableStateFlow(PrestamoListUiState())
    val uiState: StateFlow<PrestamoListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect{
                list -> _uiState.update {
                    it.copy(prestamo = list)
            }
            }
        }
    }


    fun deletePrestamo(prestamo: Prestamo)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(prestamo)
        }
    }

}