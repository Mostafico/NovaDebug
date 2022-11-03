package com.example.novadebug.screens.reservations

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.novadebug.model.clinic.reservation.Reservation
import com.example.novadebug.util.CLIENTS_COLLECTION
import com.example.novadebug.util.CLIENT_NAME
import com.example.novadebug.util.CLIENT_RESERVATIONS
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "ReservationsViewModel"

@HiltViewModel
class ReservationsViewModel @Inject constructor() : ViewModel() {
    val reservations = mutableStateListOf<Reservation>()
    private val db = Firebase.firestore

    fun updateReservations(){
        db.collection(CLIENTS_COLLECTION).document(CLIENT_NAME).collection(CLIENT_RESERVATIONS).get()
            .addOnSuccessListener {
                    documents ->
                for (document in documents){
                    Log.d(TAG, "reservationsViewModel: ${document.id} --> ${document.data}")
                    val reservation = document.toObject<Reservation>()
                    Log.d(TAG, "reservationsViewModel: ${reservation.id}")
                    reservations.add(reservation)
                }
            }.addOnFailureListener {
                Log.d(TAG, "reservationsViewModel: Failed to retrieve data")
            }
    }
}