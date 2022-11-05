package com.example.novadebug.presentation.reservations.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.novadebug.domain.repository.Reservations

@Composable
fun ReservationContent(
    padding: PaddingValues,
    reservations: Reservations,
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(padding)) {
        items(reservations) { reservation ->
            ReservationCard(reservation)
        }
    }
}