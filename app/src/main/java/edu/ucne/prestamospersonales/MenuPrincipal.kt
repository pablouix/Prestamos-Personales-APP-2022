package edu.ucne.prestamospersonales

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MenuPrincipal(

    onClickOcupationR: () -> Unit,
    onClickPersonR: () -> Unit,
    onClickPrestamoR: () -> Unit,
    onClickPrestamoL: () -> Unit,
    onClickPrestamoA: () -> Unit

){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Add a Ocupacione"
            )
            Text(
                text = "Menu",
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Build, contentDescription = "Add a Ocupacione",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(text = "Registro Ocupaciones", fontSize = 20.sp)
            }

            Button(
                onClick = onClickOcupationR, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),

            ) {
                Text(text = "Entrar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Card(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Add a Ocupacione",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(text = "Registro Personas", fontSize = 20.sp)
            }

            Button(
                onClick = onClickPersonR, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp)
            ) {
                Text(text = "Entrar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Card(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Text(text = "$", fontSize = 30.sp)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Registro Prestamos", fontSize = 20.sp)
            }

            Button(
                onClick = onClickPrestamoR, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp)
            ) {
                Text(text = "Entrar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.List, contentDescription = "Add a Ocupacione",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(text = "Consulta Prestamos", fontSize = 20.sp)
            }

            Button(
                onClick = onClickPrestamoL, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp)
            ) {
                Text(text = "Entrar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart, contentDescription = "Add a Ocupacione",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(text = "API ARTICULOS", fontSize = 20.sp)
            }

            Button(
                onClick = onClickPrestamoA, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp)
            ) {
                Text(text = "Entrar")
            }
        }


    }

 }


