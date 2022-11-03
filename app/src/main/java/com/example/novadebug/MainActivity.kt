package com.example.novadebug

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.novadebug.model.clinic.reservation.Reservation
import com.example.novadebug.navigation.SetupNavGraph
import com.example.novadebug.screens.reservations.ReservationScreen
import com.example.novadebug.ui.theme.NovaDebugTheme
import com.example.novadebug.util.CLIENTS_COLLECTION
import com.example.novadebug.util.CLIENT_NAME
import com.example.novadebug.util.CLIENT_RESERVATIONS
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore

        db.collection(CLIENTS_COLLECTION).document(CLIENT_NAME).collection(CLIENT_RESERVATIONS).get()
            .addOnSuccessListener {
                documents -> 
                for (document in documents){
                    Log.d(TAG, "onCreate: ${document.id} --> ${document.data}")
                    val reservation = document.toObject<Reservation>()
                    Log.d(TAG, "onCreate: ${reservation.id}")
                }
            }.addOnFailureListener {
                Log.d(TAG, "onCreate: Failed to retrieve data")
            }

        setContent {
            NovaDebugTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
