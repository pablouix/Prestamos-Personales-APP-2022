

package edu.ucne.prestamospersonales.ui.ocupation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.InputMode.Companion.Keyboard
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.R


import edu.ucne.prestamospersonales.util.Screen
import java.text.NumberFormat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupationScreen(
    onNavigateBack: () -> Unit,
    viewModel: OcupationViewModel = hiltViewModel()
) {

    var descripcionError by remember { mutableStateOf(false) }
    var salarioError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Registro de ocupaciones") })
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
                placeholder = { Text("Digita la ocupacion") },
                maxLines = 3,
                value = viewModel.descripcion,
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
                label = { Text(text = "Salario") },
                placeholder = { Text("Digita el salario") },
                value = viewModel.salario.toString(),
                onValueChange = {
                    viewModel.salario = it.toString().toDouble()
                    salarioError = false
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = salarioError
            )

            if (salarioError) {
                Text(
                    text = "Salario es obligatorio",
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
                    else if (viewModel.salario.toString().isBlank())
                        salarioError = viewModel.salario.toString().isBlank()
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

            Text(text = "")


        }
    }

}

/*
@Composable
@Preview(showSystemUi = true)
fun Preview() {
    OcupationScreen()
}

 */