package com.example.novadebug.presentation.reservations


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.novadebug.common.components.TopBar
import com.example.novadebug.domain.model.clinic.Doctor
import com.example.novadebug.domain.model.clinic.reservation.Reservation
import com.example.novadebug.presentation.reservations.components.AddReservation
import com.example.novadebug.presentation.reservations.components.AddReservationFab
import com.example.novadebug.presentation.reservations.components.ReservationContent
import com.example.novadebug.presentation.reservations.components.Reservations
import com.google.firebase.Timestamp

var dummyReservation = Reservation(
    id = "",
    area = arrayListOf("area 1", "area 2"),
    branch = "roshdi",
    device = "candela",
    doctor = Doctor(id = "22222"),
    status = "scheduled",
    time = Timestamp.now(),
    userId = "44444",
    expectedDuration = 30
)

@Composable
fun ReservationScreen(
    viewModel: ReservationsViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = { TopBar() },
        content = { padding ->
            Reservations(
                reservationContent = { reservations ->
                    ReservationContent(
                        padding = padding,
                        reservations = reservations
                    )
                }
            )

        },
        floatingActionButton = {
            AddReservationFab(
                addReservation = { viewModel.addReservation(dummyReservation) }
            )
        }
    )
    AddReservation()
}

