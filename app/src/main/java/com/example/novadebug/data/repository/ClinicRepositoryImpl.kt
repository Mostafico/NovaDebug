package com.example.novadebug.data.repository

import com.example.novadebug.domain.model.clinic.reservation.Reservation
import com.example.novadebug.domain.repository.ClinicRepository
import com.example.novadebug.domain.repository.ReservationsResponse
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import com.example.novadebug.domain.model.Response.*
import kotlinx.coroutines.channels.awaitClose

class ClinicRepositoryImpl @Inject constructor(
    private val reservationsRef: CollectionReference,
) : ClinicRepository {
    override fun getReservations(): Flow<ReservationsResponse> {
        return callbackFlow {
            val snapshotListener = reservationsRef.addSnapshotListener { snapshot, error ->
                val reservationsResponse = if (snapshot != null) {
                    val reservations = snapshot.toObjects(Reservation::class.java)
                    Success(reservations)
                } else {
                    Failure(error!!)
                }
                trySend(reservationsResponse)
            }
            awaitClose {
                snapshotListener.remove()
            }
        }
    }
}