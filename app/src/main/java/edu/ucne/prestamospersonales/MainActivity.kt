package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonales.ui.ocupation.OcupationScreen


import edu.ucne.prestamospersonales.ui.person.PersonScreen
import edu.ucne.prestamospersonales.ui.prestamo.PrestamoScreen
import edu.ucne.prestamospersonales.ui.prestamo_list.PrestamoListScreen

import edu.ucne.prestamospersonales.util.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity(){
  //  private lateinit var buttonsave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorScheme.background
            ) {
                val navController = rememberNavController()


                NavHost(
                    navController = navController,

                    startDestination = Screen.MenuPrincipal.route
                ) {
                    composable(Screen.MenuPrincipal.route){
                        MenuPrincipal(
                            onClickOcupationR = {navController.navigate(Screen.OcupationScreen.route)},
                            onClickPersonR = {navController.navigate(Screen.PersonScreen.route)},
                            onClickPrestamoR = { navController.navigate(Screen.PrestamoScreen.route) },
                            onClickPrestamoL = { navController.navigate(Screen.PrestamoListScreen.route) }
                        )
                    }


                    composable(Screen.OcupationScreen.route){
                        OcupationScreen({navController.navigateUp()})
                    }

                    composable(Screen.PersonScreen.route){
                        PersonScreen({navController.navigateUp()})
                    }

                    composable(Screen.PrestamoScreen.route){
                        PrestamoScreen({navController.navigateUp()})
                    }
                    composable(Screen.PrestamoListScreen.route){
                        PrestamoListScreen({navController.navigateUp()})
                    }




                }
            }
        }
    }
}
