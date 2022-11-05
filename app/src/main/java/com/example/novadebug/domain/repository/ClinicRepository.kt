package com.example.novadebug.domain.repository

import com.example.novadebug.domain.model.Response
import com.example.novadebug.domain.model.clinic.reservation.Reservation
import kotlinx.coroutines.flow.Flow


typealias Reservations = List<Reservation>
typealias ReservationsResponse = Response<Reservations>

interface ClinicRepository {
    fun getReservations(): Flow<ReservationsResponse>
}