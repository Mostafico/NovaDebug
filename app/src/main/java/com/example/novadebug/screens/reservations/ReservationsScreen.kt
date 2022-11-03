package com.example.novadebug.screens.reservations

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.novadebug.model.clinic.reservation.Reservation

@Composable
fun ReservationScreen(
    reservationsViewModel: ReservationsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        reservationsViewModel.updateReservations()
    }

    val reservations = reservationsViewModel.reservations

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Nova Clinic")})},
        content = {
            ReservationList(reservations)
        }
    )
}

@Composable
fun ReservationList(items: List<Reservation>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(items = items) { item ->
            Text(text = item.id)
        }
    }
}