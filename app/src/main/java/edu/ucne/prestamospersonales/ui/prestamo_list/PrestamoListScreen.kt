package edu.ucne.prestamospersonales.ui.prestamo_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
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
import edu.ucne.prestamospersonales.model.Prestamo
import edu.ucne.prestamospersonales.ui.prestamo.PrestamoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoListScreen(
    onClick: () -> Unit,
    viewModel: PrestamoListViewModel = hiltViewModel(),
    _viewMode: PrestamoViewModel = hiltViewModel()
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

        val uiState by viewModel.uiState.collectAsState()


        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            PrestamoList(
                viewModel,
                onClick,
                prestamo = uiState.prestamo,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            )

        }



    }

}

@Composable
fun PrestamoList(
    viewModel: PrestamoListViewModel = hiltViewModel(),
   // _viewMode: PrestamoViewModel = hiltViewModel(),
    onClick: () -> Unit,
    prestamo: List<Prestamo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(prestamo) { prestamo ->
            PrestamoRow(viewModel,prestamo, onClick)
        }
    }
}

@Composable
fun PrestamoRow(viewModel: PrestamoListViewModel, prestamo: Prestamo, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = prestamo.prestamosId.toString(),
            style = MaterialTheme.typography.titleLarge
        )
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = prestamo.concepto)
                Text(
                    text = "Balance: ${prestamo.balance}"
                )

                Row() {
                    IconButton(onClick = { viewModel.deletePrestamo(prestamo) }) {
                        Icon(
                            imageVector = Icons.Default.Delete,contentDescription = "Add a Ocupacione"
                        )
                    }

                    IconButton({ }) {
                        Icon(
                            imageVector = Icons.Default.Create,contentDescription = "Add a Ocupacione"
                        )
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${prestamo.fecha} - ${prestamo.venceFecha}")
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