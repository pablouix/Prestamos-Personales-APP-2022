package edu.ucne.prestamospersonales.ui.articulos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.data.remota.ArticulosApi
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

    var _uiState = MutableStateFlow(ArticuloListUiState())
    //var uiState: StateFlow<ArticuloListUiState> = _uiState.asStateFlow()

 /*   init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(articulos = repository.getArticulos().sortedBy { it.articuloId })
            }
        }
    }
    */

    init {
        viewModelScope.launch {
           var list = repository.getArticulos()
            _uiState.update {
                it.copy(
                    articulos = list.map {
                    articuloResponse ->
                    //estamos creando una lista
                    ArticuloResponse(
                        articuloId = articuloResponse.articuloId,
                        descripcion = articuloResponse.descripcion,
                        marca = articuloResponse.marca,
                        precio = articuloResponse.precio,
                        existencia = articuloResponse.existencia
                    )
                })
            }
        }
    }


    fun deleteArticulos(articuloResponse: ArticuloResponse)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteArticulos(articuloResponse.articuloId)
        }
    }
}

