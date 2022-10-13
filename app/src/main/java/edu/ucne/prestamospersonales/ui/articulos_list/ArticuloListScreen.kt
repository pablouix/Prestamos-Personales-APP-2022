package edu.ucne.prestamospersonales.ui.articulos_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.data.remota.ArticulosApi
import edu.ucne.prestamospersonales.data.remota.dto.ArticuloResponse
import edu.ucne.prestamospersonales.model.Prestamo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticuloListScreen(
    onClick: () -> Unit,
    viewModel: ArticuloListViewModel = hiltViewModel(),
){

    Column( modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Consulta de prestamos",
            fontStyle = FontStyle.Normal,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        val uiState by viewModel._uiState.collectAsState()


        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            PrestamoList(
                viewModel,
                onClick,
                articulo = uiState.articulos,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            )

        }



    }

}

@Composable
fun PrestamoList(
    viewModel: ArticuloListViewModel = hiltViewModel(),
    onClick: () -> Unit,
    articulo: List<ArticuloResponse>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(articulo) { articulo ->
            PrestamoRow(viewModel,articulo, onClick)
        }
    }
}

@Composable
fun PrestamoRow(viewModel: ArticuloListViewModel, articulo: ArticuloResponse, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = articulo.articuloId.toString(),
            style = MaterialTheme.typography.titleLarge
        )
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = articulo.descripcion)
                Text(
                    text = "Balance: ${articulo.marca}"
                )


            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${articulo.existencia}  ${articulo.precio}")
            }
        }
     

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}