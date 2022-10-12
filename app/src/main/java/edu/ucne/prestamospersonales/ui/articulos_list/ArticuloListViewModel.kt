package edu.ucne.prestamospersonales.ui.articulos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import edu.ucne.prestamospersonales.model.Prestamo
import edu.ucne.prestamospersonales.repository.ApiArticuloRepository
import edu.ucne.prestamospersonales.repository.PrestamoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticuloListUiState(
    val articulos: List<ArticuloResponse> = emptyList(),
)


@HiltViewModel

class ArticuloListViewModel @Inject constructor(
    val repository: ApiArticuloRepository
) : ViewModel(){

    private val _uiState = MutableStateFlow(ArticuloListUiState())
    val uiState: StateFlow<ArticuloListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(articulos = repository.get().sortedBy { it.ariticuloId })
            }
        }
    }
}

