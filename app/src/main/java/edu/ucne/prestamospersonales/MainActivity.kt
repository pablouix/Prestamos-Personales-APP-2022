package edu.ucne.prestamospersonales

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint



import edu.ucne.prestamospersonales.ui.ocupation.OcupationScreen

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
                    startDestination = Screen.OcupationScreen.route
                ) {
                    /*
                    composable(Screen.OcupationScreen.route) {
                        StudentListScreen(
                            onClick = { navController.navigate(Screen.OcupationScreen.route) }
                        )
                    }

                     */


                   composable(Screen.OcupationScreen.route) {
                      // OcupationScreen()
                       OcupationScreen({ navController.navigateUp() })
                   }


                }




            }


           // val sendButton = findViewById<Button>()
        }
    }
}
