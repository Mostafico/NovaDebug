package com.example.novadebug.screens.reservations

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun ReservationScreen(
    reservationsViewModel: ReservationsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        content = {
            ReservationList()
        }
    )
}

@Composable
fun ReservationList() {
    Text(text = "Hello World")
}