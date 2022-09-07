package edu.ucne.prestamospersonales.util

sealed class Screen(val route : String) {
    object OcupationScreen: Screen("Ocupation")
}