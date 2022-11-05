package com.example.novadebug.presentation.reservations.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.novadebug.R

@Composable
fun AddReservationFab(
    addReservation: () -> Unit,
) {
    FloatingActionButton(
        onClick = addReservation,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_reservation)
        )
    }
}