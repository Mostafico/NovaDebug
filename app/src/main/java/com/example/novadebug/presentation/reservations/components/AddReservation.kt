package com.example.novadebug.presentation.reservations.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.novadebug.common.components.ProgressBar
import com.example.novadebug.domain.model.Response.*
import com.example.novadebug.presentation.reservations.ReservationsViewModel

@Composable
fun AddReservation(
    viewModel: ReservationsViewModel = hiltViewModel(),
) {
    when (val addReservationResponse = viewModel.addReservationResponse) {
        is Loading -> ProgressBar()

        is Success,
        -> Unit

        is Failure,
        -> print(addReservationResponse.e)
    }
}