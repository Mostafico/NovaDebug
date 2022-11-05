package com.example.novadebug.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.novadebug.presentation.reservations.ReservationScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Reservations.route) {
        composable(route = Screen.Reservations.route){
            ReservationScreen()
        }
    }
}