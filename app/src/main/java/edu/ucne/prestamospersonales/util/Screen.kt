package edu.ucne.prestamospersonales.util

sealed class Screen(val route : String) {
    object OcupationScreen: Screen("Ocupation")
    object PersonScreen: Screen("Person")
    object  PrestamoScreen: Screen("Prestamo")
    object  PrestamoListScreen: Screen("Prestamo List")
    object MenuPrincipal: Screen("MenuPrincipal")
}