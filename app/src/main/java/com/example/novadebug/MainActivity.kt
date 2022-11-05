package com.example.novadebug

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.novadebug.model.clinic.reservation.Reservation
import com.example.novadebug.navigation.SetupNavGraph
import com.example.novadebug.presentation.reservations.ReservationScreen
import com.example.novadebug.presentation.ui.theme.NovaDebugTheme
import com.example.novadebug.util.CLIENTS_COLLECTION
import com.example.novadebug.util.CLIENT_NAME
import com.example.novadebug.util.CLIENT_RESERVATIONS
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaDebugTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
