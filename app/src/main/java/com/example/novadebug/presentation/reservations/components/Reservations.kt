package com.example.novadebug.presentation.reservations.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.novadebug.common.components.ProgressBar
import com.example.novadebug.domain.model.Response.*
import com.example.novadebug.domain.repository.Reservations
import com.example.novadebug.presentation.reservations.ReservationsViewModel

@Composable
fun Reservations(
    viewModel: ReservationsViewModel = hiltViewModel(),
    reservationContent: @Composable (reservations: Reservations) -> Unit,
) {
    when (val reservationsResponse = viewModel.reservationsResponse) {
        is Loading -> ProgressBar()
        is Success -> reservationContent(reservationsResponse.data)
        is Failure -> print(reservationsResponse.e)
    }

}