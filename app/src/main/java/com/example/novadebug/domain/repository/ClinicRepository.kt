package com.example.novadebug.domain.repository

import com.example.novadebug.domain.model.Response
import com.example.novadebug.domain.model.clinic.Reservation
import kotlinx.coroutines.flow.Flow


typealias Reservations = List<Reservation>
typealias ReservationsResponse = Response<Reservations>
typealias AddReservationResponse = Response<Boolean>

interface ClinicRepository {
    fun getReservations(): Flow<ReservationsResponse>

    suspend fun addReservation(reservation: Reservation): AddReservationResponse
}