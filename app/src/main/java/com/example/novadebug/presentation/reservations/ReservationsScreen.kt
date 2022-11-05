package com.example.novadebug.presentation.reservations


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.novadebug.common.components.TopBar
import com.example.novadebug.presentation.reservations.components.ReservationContent
import com.example.novadebug.presentation.reservations.components.Reservations


@Composable
fun ReservationScreen() {
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

        }
    )
}

