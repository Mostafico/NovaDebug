package com.example.novadebug.presentation.reservations

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.novadebug.model.clinic.Doctor
import com.example.novadebug.model.clinic.reservation.Reservation
import com.google.firebase.Timestamp


@Composable
fun ReservationScreen(
    reservationsViewModel: ReservationsViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    // Todo : is this the right value for the key? "true" will make this block execute only once.
    LaunchedEffect(key1 = true) {
        reservationsViewModel.updateReservations()
    }

    val reservations = reservationsViewModel.reservations
    val isLoading = reservationsViewModel.loading

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Nova Clinic") }) },
        content = {
            ReservationScreenContent(reservations, isLoading.value)
        }
    )
}

@Composable
fun ReservationScreenContent(items: List<Reservation>, isLoading: Boolean) {
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Loading")
        }
    } else {
        ReservationList(items = items)
    }

}

@Composable
fun ReservationList(items: List<Reservation>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = items) { item ->
            ReservationCardItem(reservation = item)
        }
    }
}

@Composable
fun ReservationCardItem(reservation: Reservation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(com.example.novadebug.R.drawable.man),
                contentDescription = "Round corner image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10))
            )
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = reservation.id, style = MaterialTheme.typography.subtitle1)

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = reservation.branch)
                    Text(text = reservation.device)
                }

            }
        }
    }
}

@Preview
@Composable
fun ReservationListPreview() {
    val reservation = Reservation(
        id = "1FRFZpSa7fWPlsaYJc7E",
        area = arrayListOf(
            "area1",
            "area2"
        ),
        branch = "smoha",
        device = "candela",
        doctor = Doctor(
            id = "RfCDM6o8knwSElvVhK33"
        ),
        status = "scheduled",
        time = Timestamp.now(),
        userId = "o2SG28pYMx8TgicYdTlu",
        expectedDuration = 30
    )
    val reservationsList = listOf(
        reservation,
        reservation.copy(status = "canceled"),
        reservation.copy(expectedDuration = 15),
        reservation.copy(status = "canceled")
    )
    ReservationList(
        reservationsList
    )
}

@Preview
@Composable
fun ReservationCardItemPreview() {
    ReservationCardItem(
        reservation = Reservation(
            id = "1FRFZpSa7fWPlsaYJc7E",
            area = arrayListOf(
                "area1",
                "area2"
            ),
            branch = "smoha",
            device = "candela",
            doctor = Doctor(
                id = "RfCDM6o8knwSElvVhK33"
            ),
            status = "scheduled",
            time = Timestamp.now(),
            userId = "o2SG28pYMx8TgicYdTlu",
            expectedDuration = 30
        )
    )
}