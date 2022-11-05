package com.example.novadebug.presentation.reservations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.novadebug.R
import com.example.novadebug.domain.model.clinic.reservation.Reservation

@Composable
fun ReservationCard(reservation: Reservation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 16.dp)
        ,
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(R.drawable.man),
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