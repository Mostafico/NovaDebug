package com.example.novadebug.data.repository

import android.util.Log
import com.example.novadebug.domain.model.clinic.reservation.Reservation
import com.example.novadebug.domain.repository.ClinicRepository
import com.example.novadebug.domain.repository.ReservationsResponse
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import com.example.novadebug.domain.model.Response.*
import com.example.novadebug.domain.repository.AddReservationResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.tasks.await

private var TAG = ClinicRepositoryImpl::class.java.simpleName

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
                    Log.d(TAG, "Error ${error}")
                    Failure(error!!)
                }
                trySend(reservationsResponse)
            }
            awaitClose {
                snapshotListener.remove()
            }
        }
    }

    override suspend fun addReservation(reservation: Reservation): AddReservationResponse {
        return try {
            val id = reservationsRef.document().id
            val resCopy = reservation.copy(id = id)
            reservationsRef.document(id).set(resCopy).await()
            Log.d(TAG, "Added Document Successfully with ID : ${id}")
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}