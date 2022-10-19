package edu.ucne.prestamospersonales.ui.articulos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticuloScreen(
    onNavigateBack: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel()

) {
    /*

    val articuloId: Int = 0,
    val descripcion: String = "",
    val marca: String = "",
    val precio: Double = 0.0,
    val existencia: Double = 0.0,

     */
    var descripcionError by remember { mutableStateOf(false) }
    var marcaError by remember { mutableStateOf(false) }
    var precioError by remember { mutableStateOf(false) }
    var existenciaError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Registro de articulos api") })
        },
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion") },
                placeholder = { Text("Digita la descripcion del articulo") },
                maxLines = 3,
                value = viewModel.descripcion,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                    viewModel.descripcion = it
                    descripcionError = false
                },
                isError = descripcionError
            )
            if (descripcionError) {
                Text(
                    text = "Descripcion es obligatorio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Marca") },
                placeholder = { Text("Digita la marca del articulo") },
                maxLines = 2,
                value = viewModel.marca,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                    viewModel.marca = it
                    marcaError = false
                },
                isError = marcaError
            )
            if (marcaError) {
                Text(
                    text = "Marca es obligatorio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Precio") },
                placeholder = { Text("Digita el precio del articulo") },
                maxLines = 1,
                value = viewModel.precio,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    viewModel.precio = it
                    precioError = false
                },
                isError = precioError
            )
            if (precioError) {
                Text(
                    text = "Precio es obligatorio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Existencia") },
                placeholder = { Text("Digita el existencia del articulo") },
                maxLines = 2,
                value = viewModel.existencia,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    viewModel.existencia = it
                    existenciaError = false
                },
                isError = existenciaError
            )
            if (existenciaError) {
                Text(
                    text = "Existencia es obligatorio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = {
                    if (viewModel.descripcion.isBlank())
                        descripcionError = viewModel.descripcion.isBlank()
                    else if(viewModel.marca.isBlank())
                        marcaError = viewModel.marca.isBlank()
                    else if (viewModel.precio.toString().isBlank())
                        precioError = viewModel.precio.isBlank()
                    else if(viewModel.precio.toDouble()<=0)
                        precioError = viewModel.precio.toDouble()<=0
                    else if (viewModel.existencia.toString().isBlank())
                        existenciaError = viewModel.existencia.toString().isBlank()
                    else if(viewModel.existencia.toDouble()<=0)
                        existenciaError = viewModel.existencia.toDouble()<=0
                    else {
                        viewModel.Save()
                        onNavigateBack()
                    }
                }, modifier =
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            ) {

                Icon(
                    painter = painterResource(R.drawable.save_white_24dp),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Guardar", fontSize = 16.sp)
            }


        }




    }
}
