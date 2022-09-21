package edu.ucne.prestamospersonales.ui.prestamo

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.R
import edu.ucne.prestamospersonales.model.Ocupation
import edu.ucne.prestamospersonales.model.Person
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen(
    onNavigateBack: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel(),

    ) {
    //Validaciones
    var conceptoError by remember { mutableStateOf(false) }
    var fechaError by remember { mutableStateOf(false) }
    var selectpersonaError by remember { mutableStateOf(false) }
    var balanceError by remember { mutableStateOf(false) }
    var fechaVencimientoError by remember { mutableStateOf(false) }

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
            viewModel.fecha = "$dia/${mes + 1}/$anio"
            date.value = "$dia/${mes + 1}/$anio"
            fechaError = false
        }, anio, mes, dia
    )
    //obtener fecha fin






    val dateVen = remember { mutableStateOf("") }

    val datePickerDialogoVenc = DatePickerDialog(
        context,
        { DatePicker, anio: Int, mes: Int, dia: Int ->
            viewModel.vencefecha = "$dia/${mes + 1}/$anio"
            dateVen.value = "$dia/${mes + 1}/$anio"
            fechaError = false
        }, anio, mes, dia
    )

    var personaselected by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val personas = listOf(
        Person(1, "Pablo Burgos", "809-555-5555","809-555-5555",
            "pablo@gmail.com", "SFM","01/01/2004", 1, 900.0),
        Person(1, "Pedro Casal", "809-555-5555","809-555-5555",
            "pedro@gmail.com", "Tenares","01/01/2004", 2, 500.0),
        Person(1, "Fernanda Mora", "809-555-5555","809-555-5555",
            "fernanda@gmail.com", "Salcedo","01/01/2003", 1, 2900.0)

    )


    /*
    Hacer un registro de persona  (recuerde Validar todos los campos perfectamente)
    Campos: PersonaId, Nombres,Telefono, Celular, Email, Direccion, FechaNacimiento, OcupacionId
     */

    Column( modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        //titulo
        Text(
            text = "Registro de prestamos",
            fontStyle = FontStyle.Normal,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = viewModel.concepto,
            onValueChange = {
                viewModel.concepto = it
                conceptoError = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Concepto") },
            placeholder = { Text(text = "Digita tu concepto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            isError = conceptoError
        )

        if (conceptoError) {
            Text(
                text = "Concepto es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        OutlinedTextField(
            value = date.value,
            onValueChange = {},
            label = { Text("Fecha",) },
            placeholder = { Text(date.value) },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = true,
            isError = fechaError,

            trailingIcon = {
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
                text = "Fecha es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }


        OutlinedTextField(
            value = dateVen.value,
            onValueChange = {},
            label = { Text("Fecha de vencimiento",) },
            placeholder = { Text(dateVen.value) },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = true,
            isError = fechaVencimientoError,

            trailingIcon = {
                IconButton(onClick = { datePickerDialogoVenc.show() }) {
                    Icon(

                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Botón para elegir fecha"
                    )
                }
            }
        )

        if (fechaVencimientoError) {
            Text(
                text = "Fecha de vencimiento es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }



        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = personaselected,
            onValueChange = {
                personaselected = it
            },
            label = { Text(text = "Selecciona persona") },
            isError = selectpersonaError,

            //trailingIcon
            //leandingIcon
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Botón para elegir persona"
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

            personas.forEach { person ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    personaselected = person.nombres
                    viewModel.personaId = person.personaId
                    selectpersonaError = false
                }
                ) {
                    Text(text = person.nombres)
                }
            }

        }

        if (selectpersonaError) {
            Text(
                text = "Persona es obligatorio",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }


        OutlinedTextField(
            value = viewModel.balance.toString(),
            onValueChange = {
                viewModel.balance = it.toDouble()
                balanceError = false},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Balance") },
            placeholder = { Text(text = "Digita tu balance") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = balanceError
        )

        if (balanceError) {
            Text(
                text = "Balance es obligatorio",
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
                if (viewModel.concepto.isBlank()) {
                    conceptoError = viewModel.concepto.isBlank()

                } else if(viewModel.fecha.isBlank()){
                    fechaError = viewModel.fecha.isBlank()
                } else if(viewModel.vencefecha.isBlank()){
                    fechaError = viewModel.vencefecha.isBlank()
                }
                else if (personaselected.isBlank())
                {
                    selectpersonaError = personaselected.isBlank()
                }
                else if (viewModel.concepto.isBlank())
                {
                    conceptoError = viewModel.concepto.isBlank()
                }
               // else if (viewModel.balance<0)
              //  {
                 //   balanceError = viewModel.balance<0
               // }
                else {
                    viewModel.Save()
                    onNavigateBack()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Icon(painter = painterResource(R.drawable.save_white_24dp), contentDescription = null )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Guardar", fontSize = 16.sp)
        }
    }
}