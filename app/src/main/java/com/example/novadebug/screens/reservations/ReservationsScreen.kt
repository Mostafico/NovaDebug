package com.example.novadebug.screens.reservations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
    val isLoading = reservationsViewModel.loading

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Nova Clinic")})},
        content = {
            ReservationList(reservations, isLoading.value)
        }
    )
}

@Composable
fun ReservationList(items: List<Reservation>, isLoading: Boolean) {
    if (isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "Loading")
        }
    }else{
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(items = items) { item ->
                Text(text = item.id)
            }
        }
    }

}