package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonales.ui.articulos.ArticuloScreen
import edu.ucne.prestamospersonales.ui.articulos_list.ArticuloListScreen
import edu.ucne.prestamospersonales.ui.ocupation.OcupationScreen
import edu.ucne.prestamospersonales.ui.person.PersonScreen
import edu.ucne.prestamospersonales.ui.prestamo.PrestamoScreen
import edu.ucne.prestamospersonales.ui.prestamo_list.PrestamoListScreen


import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import edu.ucne.prestamospersonales.util.Screen



@AndroidEntryPoint
class MainActivity : ComponentActivity(){
    //  private lateinit var buttonsave: Button

   // private lateinit var binding:ActivityMainBinding



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
                            onClickPrestamoL = { navController.navigate(Screen.PrestamoListScreen.route) },
                            onClickPrestamoA = { navController.navigate(Screen.ArticuloListScreen.route) },
                            onClickPrestamoAR = { navController.navigate(Screen.ArticuloScreen.route) }
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


                    composable(Screen.ArticuloListScreen.route){
                        ArticuloListScreen({navController.navigateUp()})
                    }

                    composable(Screen.ArticuloScreen.route){
                        ArticuloScreen({navController.navigateUp()})
                    }




                }
            }
        }
    }
}

/*
@AndroidEntryPoint
class MainActivity : ComponentActivity(){
  //  private lateinit var buttonsave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*
            PrestamosPersonalesTheme() {
            val navController = rememberNavController()


            NavHost(
                navController = navController,
                startDestination = "LogInScreen",

                ){
                //se declaran las rutass
                composable("LogInScreen"){
                    LogInScreen(navController)
                }

                composable("LogInScreen/{usuario}"){ // con / es obligatoria
                    navEntry ->  //cambiarle el nombre a it

                    val usuario =  navEntry.arguments?.getString("usuario") ?: "" //signo de interogacion significa que si esta nula lo otro ni lo intenta
                    // solo si es nulo queda vacio

                   // var usuario =  navEntry.arguments?.getString("usuario") !!
                    //esto no sera nula pero explota
                    LogInScreen(navController)
                }

                composable("OcupacionScreen"){
                    OcupacionScreen(navController)
                }

                composable("PersonaScreen"){
                    PersonaScreen(navController)
                }
            }
        }


            /* // para que se quede con eso guardado
            var usuario by rememberSaveable{
            mutableStateOf}
             */

            /*
              NavHost(
            navController = navController,
            startDestination = "LoginScreen",
            builder ={

            }
        )
             */

*/
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
                        Screen.OcupationScreen({ navController.navigateUp() })
                    }

                    composable(Screen.PersonScreen.route){
                        PersonScreen({navController.navigateUp()})
                    }

                    composable(Screen.PrestamoScreen.route){
                        Screen.PrestamoScreen({ navController.navigateUp() })
                    }
                    composable(Screen.PrestamoListScreen.route){
                        Screen.PrestamoListScreen({ navController.navigateUp() })
                    }




                }
            }


        }
    }


}



@Composable
fun LogInScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

       // OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Usuario")})
        //OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Contrasenia")})
       OutlinedButton(onClick = { navController.navigate("OcupacionScreen/Albert")}) {
           Text(text = "LogIn", style = MaterialTheme.typography.h2

           )

       }

    }
}
/*


@Composable
fun LogInScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

       // OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Usuario")})
        //OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Contrasenia")})
       OutlinedButton(onClick = { navController.navigate("OcupacionScreen")}) {
           Text(text = "LogIn", style = MaterialTheme.typography.h2

           )

       }

    }
}

 */
@Composable
fun OcupacionScreen(navController: NavController){
    Column() {
        Text(text = "Ocupaciones")
        OutlinedButton(onClick = { navController.navigate("PersonaScreen") }) {
            Text(text = "Persona")
        }
    }
}

@Composable
fun PersonaScreen(navController: NavController){
    Column() {
        Text(text = "Persona")
    }
}

*/

//Ocupaciones
//Ocupaciones//10

//avisar que es anulable o opcionales
//
// buscar en la documentacion