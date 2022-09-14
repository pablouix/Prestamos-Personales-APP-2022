package edu.ucne.prestamospersonales.ui.person

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Color.BLACK
import android.widget.DatePicker
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.R
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.ui.ocupation.OcupationViewModel
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonScreen(
    onNavigateBack: () -> Unit,
    viewModel: PersonViewModel = hiltViewModel(),

) {
    //Validaciones
    var nombresError by remember { mutableStateOf(false) }
    var telefonoError by remember { mutableStateOf(false) }
    var celularError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var direccionError by remember { mutableStateOf(false) }
    var fechaError by remember { mutableStateOf(false) }
    var selectOcupacionError by remember { mutableStateOf(false) }


    //obtener fecha inicio
    val context = LocalContext.current

    val anio: Int
    val mes: Int
    val dia: Int

    val calendario = Calendar.getInstance()
    anio = calendario.get(Calendar.YEAR)
    mes = calendario.get(Calendar.MONTH)
    dia = calendario.get(Calendar.DAY_OF_MONTH)
    calendario.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialogo = DatePickerDialog(
        context,
        { DatePicker, anio: Int, mes: Int, dia: Int ->
            viewModel.fechaNacimiento = "$dia/${mes + 1}/$anio"
            date.value = "$dia/${mes + 1}/$anio"
            fechaError = false
        }, anio, mes, dia
    )
    //obtener fecha fin

    var ocupacionselected by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val ocupaciones = listOf(
        Ocupation(1, "Ingniero", "60000"),
        Ocupation(2, "Agricultor", "50000"),
        Ocupation(3, "Pintor", "40000"),
        Ocupation(4, "Maestro", "60000"),
        Ocupation(5, "Doctor", "70000")

    )


    /*
    Hacer un registro de persona  (recuerde Validar todos los campos perfectamente)
    Campos: PersonaId, Nombres,Telefono, Celular, Email, Direccion, FechaNacimiento, OcupacionId
     */

    Column(modifier = Modifier.padding(8.dp)) {
        //titulo
        Text(
            text = "Registro de personas",
            fontStyle = FontStyle.Normal,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = viewModel.nombres,
            onValueChange = {
                viewModel.nombres = it
                nombresError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nombres") },
            placeholder = { Text(text = "Digita tu nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            isError = nombresError
        )

        if (nombresError) {
            Text(
                text = "Nombre es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        OutlinedTextField(
            value = viewModel.telefono,
            onValueChange = {
                viewModel.telefono = it
                telefonoError = false },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Telefono") },
            placeholder = { Text(text = "Digita tu telefono") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),

            isError = telefonoError


        )

        if (telefonoError) {
            Text(
                text = "Telefono es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        OutlinedTextField(
            value = viewModel.celular,
            onValueChange = {
                viewModel.celular = it
                celularError = false},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Celular") },
            placeholder = { Text(text = "Digita tu celular") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = celularError
        )

        if (celularError) {
            Text(
                text = "Celular es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {
                viewModel.email = it
                emailError = false},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Digita tu email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = emailError
        )

        if (emailError) {
            Text(
                text = "Email es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        OutlinedTextField(
            value = viewModel.direccion,
            onValueChange = {
                viewModel.direccion = it
                direccionError = false},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Dirección") },
            placeholder = { Text(text = "Digita tu dirección") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 4,
            isError = direccionError
        )

        if (direccionError) {
            Text(
                text = "Direccion es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        /*
        OutlinedButton(
            onClick = { datePickerDialogo.show() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),


        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Fecha de nacimiento", fontSize = 16.sp)
        }

         */

        OutlinedTextField(

            value = date.value,
            onValueChange = {},
            label = { Text("Fecha de nacimiento",) },
            placeholder = { Text(date.value) },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = true,
            isError = fechaError,

            leadingIcon = {
                IconButton(onClick = { datePickerDialogo.show() }) {
                    Icon(

                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Botón para elegir fecha"
                    )
                }
            }
        )

        if (fechaError) {
            Text(
                text = "fecha de nacimiento es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = ocupacionselected,
            onValueChange = {
                ocupacionselected = it
              },
            label = { Text(text = "Selecciona ocupacion") },
            isError = selectOcupacionError,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Botón para elegir fecha"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            enabled = false,
            readOnly = true,
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),


            ) {

            ocupaciones.forEach { ocupation ->
                androidx.compose.material.DropdownMenuItem(onClick = {
                    expanded = false
                    ocupacionselected = ocupation.descripcion
                    viewModel.ocupacionId = ocupation.ocupacionId
                    selectOcupacionError = false
                }
                ) {
                    Text(text = ocupation.descripcion)
                }
            }

        }

        if (selectOcupacionError) {
            Text(
                text = "Ocupacion es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            //onClick = { viewModel.Save() },
            //            onClick = { if() nombresError = viewModel.nombres.isBlank() },
            onClick = {
                if (viewModel.nombres.isBlank()) {
                    nombresError = viewModel.nombres.isBlank()
                } else if(viewModel.telefono.isBlank()){
                    telefonoError = viewModel.telefono.isBlank()
                } else if(viewModel.celular.isBlank()){
                    celularError = viewModel.celular.isBlank()
                } else if(viewModel.email.isBlank()){
                    emailError = viewModel.email.isBlank()
                } else if(viewModel.direccion.isBlank()){
                    direccionError = viewModel.direccion.isBlank()
                } else if(viewModel.fechaNacimiento.isBlank()) {
                    fechaError = viewModel.fechaNacimiento.isBlank()
                }
                else if (ocupacionselected.isBlank())
                {
                    selectOcupacionError = ocupacionselected.isBlank()
                }
                else {
                    viewModel.Save()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Guardar", fontSize = 16.sp)
        }
    }
}

/*
@Composable
fun obtenerFecha(context: Context){

    val anio: Int
    val mes: Int
    val dia: Int

    val calendario = Calendar.getInstance()
    anio = calendario.get(Calendar.YEAR)
    mes = calendario.get(Calendar.MONTH)
    dia = calendario.get(Calendar.DAY_OF_MONTH)
    calendario.time = Date()

    val date = remember{ mutableStateOf("")}

    val datePickerDialogo = DatePickerDialog(
        context,
        { DatePicker, anio: Int, mes: Int, dia: Int ->
            date.value ="$anio/$mes/$anio"
        }, anio, mes, dia
    )


    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
       // horizontalAlignment = Arrangement.CenterHorizontally
    ){
        Text(text = "Selecciona fecha: ${date.value}")
        Spacer(modifier = Modifier.size(12.dp))
        Button(onClick = { datePickerDialogo.show() }) {
            Text(text="Fecha de nacimiento")

        }

    }
}


 */